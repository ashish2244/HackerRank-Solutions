import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {

   List<Integer> seq = new ArrayList<Integer>();
    List<List<Integer>> seqList = new ArrayList<List<Integer>>();
    int lastAnswer=0;
    
    for (int i = 0; i < n; i++) {
            seq = new ArrayList<Integer>();
            seqList.add(seq);
        }
    
    List<Integer> ans=new ArrayList<>();

    int size=queries.size();
    for(int i=0;i<size;i++){
        int index=((queries.get(i).get(1))^lastAnswer)%n;
        if(queries.get(i).get(0)==1){
            int toAdd=queries.get(i).get(2);
            //System.out.println(index);
            seqList.get(index).add(toAdd);
        }
        else if(queries.get(i).get(0)==2){
                int seq_size=seqList.get(index).size();
                int toadd=(queries.get(i).get(2))%seq_size;
                lastAnswer=seqList.get(index).get(toadd);
                ans.add(lastAnswer);
        }
    }
    return ans;
    }


}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.dynamicArray(n, queries);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
