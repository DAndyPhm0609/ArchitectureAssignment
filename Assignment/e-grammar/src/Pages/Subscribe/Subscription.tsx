import React, { useState } from 'react';
import './Subscription.css';

type SubscriptionOption = {
  id: number;
  name: string;
  price: string;
  features: string[];
  bestValue?: boolean;
};

const subscriptionOptions: SubscriptionOption[] = [
  { id: 1, name: 'Free', price: 'Free', features: ['125 words in Paraphraser', 'Standard and Fluency modes', 'Limited use of Synonym Slider'] },
  { id: 2, name: 'Premium', price: '$9.99/month', features: ['Unlimited words in Paraphraser', 'Unlimited Custom and 8 predefined modes', 'Full use of Synonym Slider'], bestValue: true },
  // Add more options as needed
];

const Subscription: React.FC = () => {
  const [selectedOption, setSelectedOption] = useState<SubscriptionOption | null>(null);

  const handleSelectOption = (option: SubscriptionOption) => {
    setSelectedOption(option);
    // Handle subscription logic here
  };

  return (
    <div className="subscription-container">
      <div className="header">
        <h1>Upgrade Your Writing</h1>
      </div>
      <div className="plans">
        {subscriptionOptions.map((option) => (
          <div key={option.id} className={`plan ${option.bestValue ? 'best-value' : ''}`}>
            <h2>{option.name}</h2>
            <h3>{option.price}</h3>
            <ul>
              {option.features.map((feature, index) => (
                <li key={index}>{feature}</li>
              ))}
            </ul>
            <button onClick={() => handleSelectOption(option)}>Select</button>
          </div>
        ))}
      </div>
    </div>
  );
};

export default Subscription;
