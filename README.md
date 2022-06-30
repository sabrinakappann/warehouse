My first CRUD Spring project: a stock / warehouse.

With the objective of create new items composed by this same stock items, I am using the composite design pattern to with a few modifications.
Among with the goal of construct a functional stock control (or, at least, the API for it), my personal goal is also to learn with this project - remember java and POO basics, spring, junit, etc. This is why, sometimes, you may
encounter some comments explaining briefly some annotation or whatever else, so I can remember my studies. If any of these don't seem correct, I am opening to learn the right explaining.
The goal is also ensure the quality of the project by making automatized tests.
*** I WILL BE VERY GRATEFUL FOR REVIEWS OR SUGGESTIONS FOR IMPROVEMENT (here on github or sabrinakappann@gmail.com). If I can help you back, I will sure try :)

### Basic project requisites
- Be able to create composition/kits/new items defined by other items (beeing them composition or not) in the stock, and their respective quantities needed at that composition
- Register items at the system without the need to add to stock (just register an Item)
- Defines, optionally, the minimum amount of the product and notificate if it goes bellow it (for composition, will check the quantity of all of its needed items)
- Show current stock items, which can be a component (the smaller unit of an Item) or a composition (something made from some items - compositions or components - specifying the quantity needed from each one).
- Add or remove (from a sell or a lost) items from stock -> if a composition is being added, them the necessary items for it must be subtracted
- Registration of the buyer (CPF and name should be enough)
- Transactional history: for each item added or removed, stores it among with the date of operation and (opcional) sell price and the buyer
- User auth and sessions
- Register as 'lost' at transactional history the items sold by 0 cost
- From transactional history, calculate gains (sell price - cost price) - with options to filter by buyers, that may have custum sell prices
- Graphics showing evolution of gains and losts
- A little of 'BI':
  - recommend better provides for each item (may include the wait time to get that item)
  - for recurrent buyers, calculate (or register) the possible next time it will buy items, to notificate the admins
  - from recurrent sites where admin buys items, can be done a notification when a certain item goes to a good price (not sure how I would get good           results in real time for multiple producst and multiple sites and avoiding false alarms)


### Backend - functionalities to be done to serve the requisites (the order is not mandatory):
- [X] Create the Item/Component/Compositions base Controller/Model/Data classes
- BASIC CRUD:
  - CREATE:
    - [X] Create new Components
    - [X] Create new generic Items (if Composition, no items and quantities defined yet)
    - [ ] Create new Compositions + its items/quantities
  - READ:
    - [X] List all items registered
    - [X] List all components registered
    - [ ] List all compositions registered
    - [ ] List all (generic) items IN STOCK
    - [ ] List all components IN STOCK
    - [ ] List all compositions IN STOCK

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

