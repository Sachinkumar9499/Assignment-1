import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimpleSimulation {

    // Class to represent a validator with a name and a random value (power or stake)
    static class Validator {
        String name;
        int value; // This can represent either power (for PoW) or stake (for PoS)

        public Validator(String name) {
            this.name = name;
            this.value = new Random().nextInt(100); // Random value between 0 and 99
        }
    }

    public static void main(String[] args) {
        // Simulate PoW
        List<Validator> miners = new ArrayList<>();
        miners.add(new Validator("Miner1"));
        miners.add(new Validator("Miner2"));
        miners.add(new Validator("Miner3"));

        Validator selectedMiner = miners.get(0);
        for (Validator miner : miners) {
            if (miner.value > selectedMiner.value) {
                selectedMiner = miner; // Select miner with highest power
            }
        }
        System.out.println("Selected Validator: " + selectedMiner.name + " (PoW)");
        System.out.println("Selection Logic: Selected the miner with the highest power: " + selectedMiner.value);

        // Simulate PoS
        List<Validator> stakers = new ArrayList<>();
        stakers.add(new Validator("Staker1"));
        stakers.add(new Validator("Staker2"));
        stakers.add(new Validator("Staker3"));

        Validator selectedStaker = stakers.get(0);
        for (Validator staker : stakers) {
            if (staker.value > selectedStaker.value) {
                selectedStaker = staker; // Select staker with highest stake
            }
        }
        System.out.println("\nSelected Validator: " + selectedStaker.name + " (PoS)");
        System.out.println("Selection Logic: Selected the staker with the highest stake: " + selectedStaker.value);

        // Simulate DPoS
        List<Validator> voters = new ArrayList<>();
        voters.add(new Validator("Voter1"));
        voters.add(new Validator("Voter2"));
        voters.add(new Validator("Voter3"));

        // Randomly select a voter as the delegate
        Validator selectedVoter = voters.get(new Random().nextInt(voters.size()));
        System.out.println("\nSelected Validator: " + selectedVoter.name + " (DPoS)");
        System.out.println("Selection Logic: Randomly selected a delegate: " + selectedVoter.value);
    }
}
