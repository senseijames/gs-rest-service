/*
 * One time setup
 * * * * * * * * * *
 * Create a directory for MongoDB in the expected (default) location
 *   sudo mkdir -p /data/db
 *   
 * Start the Mongo Server
 * * * * * * * * * * * * * *
 * Start mongo db
 *   sudo mongod
 *   
 * Run a mongo client
 * * * * * * * * * * * * * * 
 * Open a CLI terminal, and run the mongo client
 *   mongo
 * Create a database and switch to it
 *   use rest-db
 * Use the test database
 *   use test
 * Show databases
 *   show dbs  OR show databases
 * Show collections
 *   show collections
 * Run a script file!
 *   load('db/mongo-seed.js');
 *
 * @reference https://docs.mongodb.com/manual/tutorial/write-scripts-for-the-mongo-shell/
 * @reference https://michelebusta.com/the-little-things-5-initialize-a-local-mongo-db-8972d71b7715
 */

const conn = new Mongo();
const db = conn.getDB('test'); // Just use the already ready 'test' database.

const collections = db.getCollectionNames();
//console.log('Collections are', collections);
//console.log('Attempting insert to implicitly declared "shippingList" table...');
const isConstWorking = 'is const working!';
print('Trying output using print command in single quotes!', collections.join(" "));
print("Trying output using print command in concat double " + isConstWorking);

// Create "shippingList" collection in db, if it doesn't exist, and add new rows, if they don't exist ("_id").
db.shippingList.insert({name:"FEDEX", _id : 1 });   // _id sets that Document property, and will preclude duplicates.
db.shippingList.insert({name:"UPS", _id : 2 }); 
db.shippingList.insert({name:"DHL", _id : 3 }); 
db.shippingList.insert({name:"Other", _id : 4 });

// Create TestUsers collection, and add some new heroes!
// One time: Seed database
// const USERS = [ 'Batman', 'Spider-Man', 'Superman', 'Green Arrow', 'The Flash', 'Wonder Woman', 'Captain America', 'Iron Man' ];
const FIRSTS = [ 'Bat', 'Spider', 'Super', 'Green', 'The', 'Wonder', 'Mystery', 'Black', 'Captain', 'Iron', 'Doctor', 'Star' ];
const SECONDS = [ 'Man', 'Man', 'Lantern', 'Flash', 'Woman', 'Lightning', 'America', 'Lord', 'Wolverine', 'Atom' ];
for (var i = 0, len = Math.min(FIRSTS.length, SECONDS.length); i < len; ++i){
  var username = FIRSTS[Math.floor(Math.random() * FIRSTS.length)] + ' ' 
               + SECONDS[Math.floor(Math.random() * SECONDS.length)];
print('NEW USER', i, 'is', username);  
  var user = { name : username, coolness : Math.floor(Math.random() * 100) };
  db.TestUsers.insert(user);
}


/*
 * Utils
 * * * * * * * *
 * Use the --eval option to mongo to pass the shell a JavaScript fragment, as in the following:
 *   mongo test --eval "printjson(db.getCollectionNames())"
 *   
 * You can specify a .js file to the mongo shell, and mongo will execute the JavaScript directly.
 *   mongo localhost:27017/test myjsfile.js
 *   
 * You can execute a .js file from within the mongo shell, using the load() function, as in the following:
 *   load("myjstest.js")
 */