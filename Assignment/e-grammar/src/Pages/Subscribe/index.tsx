import React, { useState } from 'react';

interface SubscriptionOption {
    id: number;
    title: string;
    price: string; 
}

const subscriptionOptions: SubscriptionOption[] = [
    { id: 1, title: 'Basic', price: '$5/month' },
    { id: 2, title: 'Standard', price: '$10/month' },
    { id: 3, title: 'Premium', price: '$20/month' },
];

const SubscriptionPage: React.FC = () => {
    return (
      <div>
      <h1>Subscription</h1>
      <form>
          {subscriptionOptions.map(option => (
              <div key={option.id}>
                  <input 
                      type="radio" 
                      id={`option-${option.id}`} 
                      name="subscription" 
                      value={option.id} 
                  />
                  <label htmlFor={`option-${option.id}`}>
                      {option.title} - {option.price}
                  </label>
              </div>
          ))}
          <button type="button">
              Next
          </button>
      </form>
  </div>
    );
};

export default SubscriptionPage;
