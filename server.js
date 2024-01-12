const express = require("express");
const fileUpload = require("express-fileupload");
const pdfParse = require("pdf-parse");
const mammoth = require("mammoth");
const fs = require("fs");

const app = express();

app.use("/", express.static("public"));
app.use(fileUpload());

app.post("/ArchitectureAssignment", (req, res) => {
    if (!req.files || !req.files.uploadedFile) {
        res.status(400).send("No file uploaded");
        return;
    }

    const uploadedFile = req.files.uploadedFile;

    if (uploadedFile.mimetype === "application/pdf") {
        pdfParse(uploadedFile.data).then(result => {
            res.send(result.text);
        });
    } else if (uploadedFile.mimetype === "application/vnd.openxmlformats-officedocument.wordprocessingml.document") {
        // Save the .docx file to a temporary location
        const tempFilePath = __dirname + "/temp.docx";
        uploadedFile.mv(tempFilePath, (err) => {
            if (err) {
                console.error(err);
                res.status(500).send("Error saving .docx file");
                return;
            }

            // Read the saved .docx file and extract text
            mammoth.extractRawText({ path: tempFilePath })
                .then(result => {
                    // Remove the temporary file
                    fs.unlinkSync(tempFilePath);
                    res.send(result.value);
                })
                .catch(error => {
                    console.error(error);
                    res.status(500).send("Error extracting text from .docx file");
                });
        });
    } else if (uploadedFile.mimetype === "text/plain") {
        res.send(uploadedFile.data.toString());
    } else {
        res.status(400).send("Unsupported file type");
    }
});

app.listen(3000, () => {
    console.log("Server is running on port 3000");
});
