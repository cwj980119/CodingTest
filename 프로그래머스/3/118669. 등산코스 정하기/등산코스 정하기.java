import java.awt.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {

        static ArrayList<Point>[] hiking;
        static int[] spot;

        public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
            int[] answer = {0, 10000001};
            spot = new int[n+1];
            hiking = new ArrayList[n+1];
            for(int i = 0; i < n+1; i++){
                hiking[i] = new ArrayList<>();
            }
            for(int gate : gates){
                spot[gate] = 1;
            }
            for(int summit : summits){
                spot[summit] = 2;
            }
            for(int[] path : paths){
                hiking[path[0]].add(new Point(path[1], path[2]));
                hiking[path[1]].add(new Point(path[0], path[2]));
            }
            for (int gate : gates){
                int[] root = getRoot(gate, n);
                if(root[1] < answer[1]){
                    answer[0] = root[0];
                    answer[1] = root[1];
                }
                else if(root[1] == answer[1]){
                    if(root[0] < answer[0]) answer[0] = root[0];
                }
            }

            return answer;
        }

        static int[] getRoot(int start, int n){
            PriorityQueue<Point> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.y == o2.y) return o1.x-o2.x;
                return o1.y-o2.y;
            });
            int[] answer = new int[]{0, 0};
            boolean[] visited = new boolean[n+1];
            pq.add(new Point(start, 0));
            Point current = new Point(0,0);
            while(!pq.isEmpty()){
                current = pq.poll();
                if(visited[current.x]) continue;
                visited[current.x] = true;
                if(current.y > answer[1]) answer[1] = current.y;
                if(spot[current.x] == 2) break;
                for(Point p : hiking[current.x]){
                    if(visited[p.x] || spot[p.x] == 1) continue;
                    pq.add(p);
                }
            }
            if(spot[current.x] == 2){
                answer[0] = current.x;
                return answer;
            }
            else return new int[]{0, 10000001};
        }

    }