import java.util.Scanner;
public class qf {
    //入度为零或者出度为零, 最大为答案
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        int u, v;
        for (int i = 0; i < m; i++) {
            u = scanner.nextInt();
            v = scanner.nextInt();
            nodes[u].out++;
            nodes[v].in++;
        }
        int ins = 0;
        int outs = 0;
        for (int i = 1; i <= n; i++) {
            if (nodes[i].in == 0) ins++;
            if (nodes[i].out == 0) outs++;
        }
        System.out.println(Math.max(ins, outs));
    }
    static class Node{
        int id;
        int in;
        int out;
        Node(int id){
            this.in = 0;
            this.out = 0;
            this.id = id;
        }
    }
}
