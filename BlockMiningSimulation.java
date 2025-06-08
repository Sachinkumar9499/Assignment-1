import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class BlockMiningSimulation {

    // Block class representing a simple block with data, nonce, and hash
    static class Block {
        private String data; // The data contained in the block
        private int nonce;   // A counter used for mining
        private String hash; // The hash of the block

        // Constructor to initialize the block with data
        public Block(String data) {
            this.data = data;
            this.nonce = 0; // Initialize nonce to 0
            this.hash = calculateHash(); // Calculate the initial hash
        }

        // Method to calculate the SHA-256 hash of the block's data and nonce
        public String calculateHash() {
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-256"); // Create a SHA-256 digest
                String text = data + nonce; // Combine data and nonce for hashing
                byte[] hashBytes = digest.digest(text.getBytes()); // Generate the hash bytes
                StringBuilder hexString = new StringBuilder(); // StringBuilder to build the hex string

                // Convert each byte to a hex string
                for (byte b : hashBytes) {
                    String hex = Integer.toHexString(0xff & b); // Convert byte to hex
                    if (hex.length() == 1) hexString.append('0'); // Append leading zero if needed
                    hexString.append(hex); // Append hex value to the string
                }
                return hexString.toString(); // Return the final hex string
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e); // Handle exception if SHA-256 is not available
            }
        }

        // Method to mine the block by finding a valid nonce
        public void mineBlock(int difficulty) {
            String target = "0".repeat(difficulty); // Create a target string based on difficulty (e.g., "0000")
            nonce = 0; // Reset nonce for mining
            hash = calculateHash(); // Calculate the initial hash

            long startTime = System.currentTimeMillis(); // Start timer for mining

            // Loop until a hash is found that meets the difficulty condition
            while (!hash.startsWith(target)) {
                nonce++; // Increment nonce
                hash = calculateHash(); // Recalculate hash with the new nonce
            }

            long endTime = System.currentTimeMillis(); // End timer for mining
            long duration = endTime - startTime; // Calculate duration of mining

            // Output the results of the mining process
            System.out.println("\nBlock mined!");
            System.out.println("Data: " + data);
            System.out.println("Hash: " + hash);
            System.out.println("Nonce: " + nonce);
            System.out.println("Difficulty: " + difficulty);
            System.out.printf("Time taken: %.3f seconds\n", duration / 1000.0); // Print time taken in seconds
            System.out.println("Nonce attempts: " + nonce); // Print the number of nonce attempts
        }

        // Getter method to retrieve the hash of the block
        public String getHash() {
            return hash;
        }
    }

    // Main method to run the mining simulation
    public static void main(String[] args) {
        System.out.println("=== Proof-of-Work Mining Simulation ===\n");
        int difficulty = 4; // Set difficulty (hash must start with "0000")
        String blockData = "This is some block data."; // Example block data

        Block block = new Block(blockData); // Create a new block with the example data

        System.out.println("Mining block with difficulty " + difficulty + "...");
        block.mineBlock(difficulty); // Start mining the block with the specified difficulty

        System.out.println("\nSimulation complete."); // Indicate that the simulation is complete
    }
}
