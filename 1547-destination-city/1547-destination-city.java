class Solution {
    public String destCity(List<List<String>> paths) {
        HashMap<String, String> line = new HashMap<>();
        //모든 값을 해시맵에 집어넣는다.
        for (List<String> path : paths) {
            line.put(path.get(0), path.get(1));
        }
        //하나씩 값을 튕겨가면서 진행한다.
        //더이상 진행하지 못하면 그곳이 목적지
        String origin = paths.get(0).get(0);
        while (line.get(origin) != null) {
            origin = line.get(origin);
        }
        return origin;
    }
}