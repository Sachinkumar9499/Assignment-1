import java.security.MessageDigest;
import java.util.Date;

class Block {
    public int index;
    public long timestamp;
    public String data;
    public String previousHash;
    public String hash;
    public int nonce;

    public Block(int index, String data, String previousHash) {
        this.index = index;
        this.timestamp = new Date().getTime();
        this.data = data;
        this.previousHash = previousHash;
        this.nonce = 0;
        this.hash = calculateHash();
    }

    public String calculateHash() {
        try {
            String input = index + Long.toString(timestamp) + data + previousHash + nonce;
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void displayBlock() {
        System.out.println("Index: " + index);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Data: " + data);
        System.out.println("Previous Hash: " + previousHash);
        System.out.println("Hash: " + hash);
        System.out.println("Nonce: " + nonce);
        System.out.println("----------------------------");
    }
}

public class Blockchain {
    public static void main(String[] args) {
        Block block1 = new Block(1, "First Block Data", "0");
        Block block2 = new Block(2, "Second Block Data", block1.hash);
        Block block3 = new Block(3, "Third Block Data", block2.hash);

        block1.displayBlock();
        block2.displayBlock();
        block3.displayBlock();
    }
}
