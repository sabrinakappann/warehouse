My first Spring project of a stock / warehouse.
With the objective of create new items composed by this same stock items, I am using the composite design pattern to with a few modifications.

The goal is also ensure the quality of the project by making tests.
*** I WILL BE VERY GRATEFUL FOR REVIEWS OR SUGGESTIONS FOR IMPROVEMENT (here on github or sabrinakappann@gmail.com)

### Projects requisites
- Register items at the system without the need to add to stock (just register an Item)
- Defines, opcionaly, the minimum amount of the product and notificate if goes bellow it (for composition, will check the quantity of all of its needed items)
- Show current stock tems, which can be a component (the smaller unit of an Item) or a composition (something made from some items - compositions or components - specifying the quantity needed from each one).
- Add or remove (from a sell or a lost) items from stock -> if a compositon is been added, them the necessary items for it must be subtracted
- Registration of the buyer (CPF and name should be enought)
- Transacional history: for each item added or removed, stores it among with the date of operation and (opcional) sell price and the buyer
- Register as 'lost' at transacional history the items selled by 0 cost
- From transacional history, calculate gains (sell price - cost price) - with options to filter by buyers, that may have custum sell prices
- Graphics showing evolution of gains and losts
- A little of 'BI':
  - recomendate better provides for each item (may include the wait time to get that item)
  - for recurrent buyers, calculate (or register) the possible next time it will buy items, to notificate the admins
  - from recorrent sites where admin buys items, can be done a notification when a certain item goes to a good price (not sure how I would get good           results in real time for multiple producst and multiple sites and avoiding false alarms)


### Backend - functionalities to be done to serve the requisites (the order is not mandatory):
- [X] Create the Item related classes
- [ ] Create stock related classes
- [X] Endpoint to create components (register a new one)
- [ ] Endpoint to create compositions (items that are made from a group of Items, been them Components or Compositions)
- [ ] Create the USers, Sellers and Buyers related models
- [ ] Endpoint to add or remove items from stock
- [ ] Endpoint to list all items REGISTERED, with option to filter by components or compositions
- [ ] Endpoint to List all compositions a component makes a part and the amount of each of them at stock
- [ ] Endpoint to List all stock (do not include only registered items)
- [ ] Usefull filters at stock (see requisites)
- [ ] Register Transacional history
- [ ] Filter Transacional history as needed and get statistics
- [ ] Implement user autentication
- [ ] BI related parts - still under consideration



### Frontend

Still not defined

