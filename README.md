# Assignment-1
1. Blockchain.java -In this file we create 3 blocks.
Block Class: A class Block is created to represent each block in the blockchain.
Block Properties: Each block has index, timestamp, data, previousHash, hash, and nonce.
SHA-256 Hashing: The calculateHash() method uses SHA-256 to create a unique hash for the block.
Proof of Work (Mining): The mineBlock() method finds a hash starting with a set number of zeros (difficulty), simulating mining.
Nonce: A number (nonce) is incremented during mining to change the hash until it meets the difficulty condition.
Timestamp: Each block saves the time it was created using new Date().getTime().
Block Linking: Every new block stores the hash of the previous block in previousHash, linking them together.
Genesis Block: The first block (index 0) is manually created with "0" as its previous hash.
Chain Creation: Three blocks are created one after another, each referencing the previous block’s hash.
Display Blocks: All block details are printed, showing their data, hash, previous hash, and nonce.


2.BlockMiningSimulation  - In this file we solve . Simulate Proof-of-Work by mining a block that satisfies a difficulty condition.
Class Structure:The Block class is defined as a static inner class within BlockMiningSimulation, which is appropriate for encapsulating the mining logic.
The Block class has three main attributes: data, nonce, and hash.

Hash Calculation:The calculateHash() method correctly implements SHA-256 hashing using MessageDigest.
The method combines the data and nonce to generate a unique hash for each nonce value.

Mining Logic:The mineBlock(int difficulty) method correctly implements the mining process by incrementing the nonce until the hash starts with a specified number of zeros (based on the difficulty).
The use of String target = "0".repeat(difficulty); is a concise way to create the target string.

Timing:The code measures the time taken to mine the block using System.currentTimeMillis(), which is a standard approach for timing in Java.

Output:The output statements provide clear information about the mining process, including the mined hash, nonce, difficulty, time taken, and the number of nonce attempts.

Main Method:The main method initializes the mining simulation, sets the difficulty, and creates a block with example data. It then calls the mineBlock method to start the mining process.


3.SimpleSimulation: In this file we solve . Simulate and compare PoW, PoS, and DPoS logic in code.
1. Purpose: The code simulates and compares three consensus mechanisms: Proof-of-Work (PoW), Proof-of-Stake (PoS), and Delegated Proof-of-Stake (DPoS). 
2. Validator Class: A single Validator class is created to represent all types of validators, with fields for name and value (which can represent either power or stake). 
3. Random Value Generation: Each validator is initialized with a random integer value between 0 and 99, simulating their power (for PoW) or stake (for PoS). 
4. PoW Simulation: A list of miners is created, and the miner with the highest power value is selected through a simple loop. 
5. PoW Output: The selected miner's name and power value are printed, along with the logic used for selection. 
6. PoS Simulation: A list of stakers is created, and the staker with the highest stake value is selected using a similar loop. 
7. PoS Output: The selected staker's name and stake value are printed, along with the selection logic. 
8. DPoS Simulation: A list of voters is created, and a random voter is selected as the delegate using Random().nextInt(). 
9. DPoS Output: The selected voter's name and value are printed, along with the logic indicating that the selection was random. 
10. Overall Structure: The code is structured in a straightforward manner, making it easy to read and understand while demonstrating the core concepts of each consensus mechanism. 
