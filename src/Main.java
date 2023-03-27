//Joseph Kahale
//CS4310.02
//Professor Damavandi
//March 25, 2023

//Project 1 - Task 2

//

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Process Class
class Process {

    private int processID;
    private int arrivalTime;
    private int burstTime;
    private int priority;
    private int waitingTime;
    private int responseTime;
    private int turnaroundTime;
    private int cpuUtilRate;
    private int processTime;

    Process(int processID, int arrivalTime, int burstTime, int priority) {
        this.processID = processID;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }

    public int getProcessID() {
        return processID;
    }

    public void setProcessID(int processID) {
        this.processID = processID;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getWaitingTime() {
        return waitingTime;
    }

    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }

    public int getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(int responseTime) {
        this.responseTime = responseTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getCpuUtilRate() {
        return cpuUtilRate;
    }

    public void setCpuUtilRate(int cpuUtilRate) {
        this.cpuUtilRate = cpuUtilRate;
    }

    public void setProcessTime(int processTime){
        this.processTime = processTime;
    }

    public int getProcessTime(){
        return processTime;
    }

    @Override
    public String toString() {
        return this.processID + "+" + this.arrivalTime + "+" + this.burstTime + "+" + this.priority;
    }
}

public class Main {

    public static int time = 0;
    public static ArrayList<List<Integer>> group = new ArrayList<List<Integer>>();

    //Arraylist that carries process objects
    public static ArrayList<Process> processes = new ArrayList<>();

    //Preemptive Priority Scheduler Algo
    public static void preemptivePriority() throws InterruptedException {
        boolean isCompleted = false;

        int totalBurstTime = 0;

        for(int i = 0; i < processes.size(); i++){
            totalBurstTime += processes.get(i).getBurstTime();
        }

        for(int j = 0; j < totalBurstTime; j++) {

            for (int i = 1; i < processes.size(); i++) {
                if (time >= processes.get(i).getArrivalTime() && processes.get(i).getPriority() < processes.get(i - 1).getPriority()) {
                    System.out.println("Time Elapsed: " + time + "| Running Process: " + processes.get(i).getProcessID());
                    break;
                } else if (time >= processes.get(i).getArrivalTime() && processes.get(i).getPriority() > processes.get(i - 1).getPriority()) {
                    System.out.println("Time Elapsed: " + time + "| Running Process: " + processes.get(i - 1).getProcessID());
                    break;
                } else if (time >= processes.get(i).getArrivalTime() && processes.get(i).getPriority() == processes.get(i - 1).getPriority()) {
                    if (processes.get(i).getArrivalTime() < processes.get(i - 1).getArrivalTime()) {
                        System.out.println("Time Elapsed: " + time + "| Running Process: " + processes.get(i).getProcessID());
                    } else {
                        System.out.println("Time Elapsed: " + time + "| Running Process: " + processes.get(i - 1).getProcessID());
                    }
                    break;
                }
            }


            time++;
        }
    }

    //Not completed - shortest Scheduler Algo
    public static void shortestJobFirst() throws InterruptedException {
        //to be completed
    }

    //Not completed - RR Scheduler Algo
    public static void RR(int timeQuantum) throws InterruptedException {
        //to be completed
    }

    //FCFS Scheduler Algo
    public static void fcfsScheduler() throws InterruptedException {
        boolean isCompleted = false;
        boolean processCompleted = false;

        int totalBurstTime = 0;
        int[] burstTimes = new int[processes.size()];
        for (int i = 0; i < processes.size(); i++) {
            burstTimes[i] = processes.get(i).getBurstTime();
            totalBurstTime += burstTimes[i];
        }
//        time <= totalBurstTime && processes.get(j).getWaitingTime() < time
        for (int i = 0; i < totalBurstTime + 1; i++) {
            for (int j = 0; j < processes.size(); j++) {

                if(burstTimes[j] == 4){
                    processes.get(j).setResponseTime(i - processes.get(j).getArrivalTime());
                }

                if (burstTimes[j] != 0 && i >= processes.get(j).getArrivalTime()) {
                    System.out.println("Time Elapsed: " + time + "| Running Process: " + processes.get(j).getProcessID());
                    burstTimes[j]--;
//                    processes.get(j).setCpuUtilRate();
                }
                else if (burstTimes[j] == 0 && time <= totalBurstTime && time == processes.get(j).getProcessTime()) {
                    System.out.println("Time Elapsed: " + time + "| Finished Process: " + processes.get(j).getProcessID());
                }

            }
            time++;
        }

//        while (!isCompleted) {
//            int total = 0;
//            for(int i = 0; i < processes.size(); i++){
//                total = processes.get(i).getBurstTime() + total;
//
//                if(time <= processes.get(i).getProcessTime() && time < total && time > total - processes.get(i).getBurstTime() && processes.get(i).getWaitingTime() < time){
//                    System.out.println("Time Elapsed: " + time + "| Running Process: " + i);
//                }
//                else if(time == processes.get(i).getProcessTime()  && time == total){
//                    System.out.println("Time Elapsed: " + time + "| Finished Process: " + i);
//                    continue;
//                }
//
//            }
//
//            TimeUnit.SECONDS.sleep(1);
//
//            time++;
//
//        }


//        for(int i = 0; i < processes.size(); i++){
//            for(int j = 0; j < processes.get())
//            System.out.println("Started Running Process: " + i);
//        }


    }

    //Menu to print:
    //Average waiting time
    //Average response time
    //Average turnaround time
    //CPU utilization rate
    public static void computeStats(int algoChoice){
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        double avgResponseTime = 0;
        double cpuUtilRate = 0;
//        if(algoChoice == 0){

            for(int i = 0; i < processes.size(); i++){
                avgWaitingTime += processes.get(i).getWaitingTime();
                avgTurnaroundTime += processes.get(i).getTurnaroundTime();
                avgResponseTime += processes.get(i).getResponseTime();
                cpuUtilRate += processes.get(i).getCpuUtilRate();
            }
            System.out.println("_____________________________________________________");
            System.out.println("AVG WAITING TIME: " + avgWaitingTime/processes.size());
            System.out.println("_____________________________________________________");
            System.out.println("AVG RESPONSE TIME: " + avgResponseTime/processes.size());
            System.out.println("_____________________________________________________");
            System.out.println("AVG TURNAROUND TIME: " + avgTurnaroundTime/processes.size());
            System.out.println("_____________________________________________________");
            System.out.println("AVG RESPONSE TIME: " + cpuUtilRate/processes.size());
//        }


        System.out.println();
    }

    //Reads ints from file, and parses into ArrayList
    public static void readFromFile(String fileName) throws FileNotFoundException {
        File one = new File(fileName + ".txt");
        Scanner myReader = new Scanner(one);
        while(myReader.hasNextLine()) {
            String[] newLine = myReader.nextLine().trim().split(" ");
            Integer[] temp = new Integer[newLine.length];
            for(int i = 0; i < newLine.length; i++){
                temp[i] = Integer.parseInt(newLine[i]);
            }
            List<Integer> row = Arrays.asList(temp);
            group.add(row);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        //Reads from file
        System.out.println("Please enter the input file name: ");
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        readFromFile(s);
        for (int i = 0; i < group.size(); i++){
            Process one = new Process(group.get(i).get(0), group.get(i).get(1), group.get(i).get(2), group.get(i).get(3));
            processes.add(one);
        }

        //Computes Process Time, Turnaround Time, and Waiting Time
        processes.get(0).setProcessTime(processes.get(0).getBurstTime() + processes.get(0).getArrivalTime());
        for (int i = 1; i < processes.size(); i++) {
            processes.get(i).setProcessTime(processes.get(i - 1).getProcessTime() + processes.get(0).getBurstTime());
        }

        for (int i = 0; i < processes.size(); i++) {
            processes.get(i).setTurnaroundTime(processes.get(i).getProcessTime() - processes.get(i).getArrivalTime());
            processes.get(i).setWaitingTime(processes.get(i).getTurnaroundTime() - processes.get(i).getBurstTime());
        }

        //Takes in choice for algo
        System.out.println("Please choose a scheduling algorithm: 0 for FCFS, 1 for SJF, 2 for PPS, and 3 for RR: ");
        int choose = input.nextInt();

        if(choose == 0){
            Collections.sort(processes, new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return o1.getArrivalTime() - o2.getArrivalTime();
                }
            });

            fcfsScheduler();
        }
        else if(choose == 1){
            Collections.sort(processes, new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return o1.getBurstTime() - o2.getBurstTime();
                }
            });
            shortestJobFirst();
        }
        else if(choose == 2){
            Collections.sort(processes, new Comparator<Process>() {
                @Override
                public int compare(Process o1, Process o2) {
                    return o1.getPriority() - o2.getPriority();
                }
            });
            preemptivePriority();
        }
        else if(choose == 3){
            System.out.println("Please specify your time quantum: ");
            int timeQuantum = input.nextInt();
            RR(timeQuantum);
        }

        //Calls Stats method
        computeStats(choose);


    }
}