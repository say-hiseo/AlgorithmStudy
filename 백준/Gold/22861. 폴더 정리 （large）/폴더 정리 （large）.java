import java.util.*;
import java.io.*;
import java.lang.*;
public class Main {
    static Map<String, Set<String>> folderChildren = new HashMap<>();
    static Map<String, Map<String, Integer>> fileDetail = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M+N; i++) {
            st = new StringTokenizer(br.readLine());
            String P = st.nextToken();
            String F = st.nextToken();
            int c = Integer.parseInt(st.nextToken()); // 폴더라면 1, 파일이라면 0
            if(c == 1) {
                folderChildren.computeIfAbsent(P, x -> new HashSet<>()).add(F);
                folderChildren.computeIfAbsent(F, x -> new HashSet<>()); 
            } else {
                Map<String, Integer> pDetail = fileDetail.computeIfAbsent(P, x -> new HashMap<>());
                pDetail.put(F, pDetail.getOrDefault(F, 0) + 1);
            }
        }

        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            String A = st.nextToken();
            String B = st.nextToken();
            String folderA = A.substring(A.lastIndexOf("/") + 1);
            String folderB = B.substring(B.lastIndexOf("/") + 1);
            move(folderA, folderB);
        }

        StringBuilder sb = new StringBuilder();
        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            String query = br.readLine();
            String folder = query.substring(query.lastIndexOf("/") + 1);

            Map<String, Integer> result = new HashMap<>();
            collectFiles(folder, result);

            int totalType = result.size();
            int totalCount = result.values().stream().mapToInt(Integer::intValue).sum();

            sb.append(totalType).append(" ").append(totalCount).append("\n");
        }
        System.out.print(sb);
    }

    private static void move(String A, String B) {
        Map<String, Integer> aDirectFiles = fileDetail.getOrDefault(A, new HashMap<>());

        Map<String, Integer> bDetail = fileDetail.computeIfAbsent(B, x -> new HashMap<>());
        for(Map.Entry<String, Integer> entry : aDirectFiles.entrySet()) {
            String fileName = entry.getKey();
            int cnt = entry.getValue();
            if(!bDetail.containsKey(fileName)) {
                bDetail.put(fileName, cnt);
            }
        }

        for(String child : folderChildren.getOrDefault(A, new HashSet<>())) {
            folderChildren.computeIfAbsent(B, x -> new HashSet<>()).add(child);
        }

        folderChildren.put(A, new HashSet<>());
        fileDetail.put(A, new HashMap<>());
    }

    private static void collectFiles(String folder, Map<String, Integer> detail) {
        Map<String, Integer> myDetail = fileDetail.getOrDefault(folder, new HashMap<>());
        for(Map.Entry<String, Integer> entry : myDetail.entrySet()) {
            detail.put(entry.getKey(), detail.getOrDefault(entry.getKey(), 0) + entry.getValue());
        }
        for(String child : folderChildren.getOrDefault(folder, new HashSet<>())) {
            collectFiles(child, detail);
        }
    }
}