import java.util.*;

public class JobSequencing {

    // Job class representing each job with deadline, profit, and an ID
    static class Job {
        int deadline;
        int profit;
        int id; // Job ID: 0(A), 1(B), 2(C)...

        public Job(int i, int d, int p) {
            id = i;        // Assign job ID
            deadline = d;  // Deadline by which job should be completed
            profit = p;    // Profit earned by completing this job
        }
    }

    public static void main(String[] args) {
        // Each job: {deadline, profit}
        int jobsInfo[][] = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        // Create Job objects and add them to the list
        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // Sort jobs in descending order of profit (higher profit first)
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit);

        ArrayList<Integer> sequence = new ArrayList<>(); // Stores selected job IDs
        int time = 0; // Keeps track of the current number of jobs scheduled

        // Select jobs while ensuring each job is done before its deadline
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                sequence.add(curr.id); // Schedule job
                time++;                // Move to next time slot
            }
        }

        // Print the result
        System.out.println("Max jobs scheduled = " + sequence.size());
        System.out.print("Job sequence (by ID): ");
        for (int i = 0; i < sequence.size(); i++) {
            System.out.print(sequence.get(i) + " ");
        }
        System.out.println();
    }
}
