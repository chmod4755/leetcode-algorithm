package top.lighten.nowcoder;

import java.util.*;

class Service {
    String name;
    ArrayList<Service> next = new ArrayList<>();

    public Service(String name, Service next) {
        this.name = name;
        if (next != null) {
            this.next.add(next);
        }
    }
}

class Q3Solution {

    HashSet<String> ws = new HashSet<>();
    HashSet<String> visited = new HashSet<>();
    HashMap<String, Service> smap = new HashMap<>();
    String[] services;

    ArrayList<String> tempList = new ArrayList<>();

    public Q3Solution() {
        Scanner sc = new Scanner(System.in);
        services = sc.nextLine().split(",");
        String[] wrongs = sc.nextLine().split(",");
        for (String wrong : wrongs) {
            ws.add(wrong);
        }
        for (String service : services) {
            String[] sers = service.split("-");
            Service first = smap.get(sers[0]);
            if (first == null) {
                first = new Service(sers[0], null);
            }
            Service start = first;
            for (int i = 1; i < sers.length; i++) {
                Service next = smap.get(sers[i]);
                if (next == null) {
                    next = new Service(sers[i], null);
                }
                start.next.add(next);
                start = next;
            }
            smap.put(first.name, first);
        }

    }

    public void solve() {
        for (Map.Entry<String, Service> entry : smap.entrySet()) {
            Service start = entry.getValue();
            tempList.clear();
            dfs(start);
            tempList.clear();
        }
        ArrayList<String> res = new ArrayList<>();
        for (String service : services) {
            String[] sers = service.split("-");
            for (String ser : sers) {
                if (!ws.contains(ser)) {
                    res.add(ser);
                }
            }
        }
        if (res.size() == 0) {
            System.out.println(",");
        } else {
            System.out.println(String.join(",", res));
        }
    }

    public void dfs(Service start) {
        if (visited.contains(start.name)) {
            return;
        }
        tempList.add(start.name);
        visited.add(start.name);
        if (ws.contains(start.name)) {
            ws.addAll(tempList);
            tempList.clear();
        }
        if (start.next.size() != 0) {
            for (Service service : start.next) {
                dfs(service);
            }
        }
        start = smap.get(start.name);
        if (start != null) {
            for (Service service : start.next) {
                dfs(service);
            }
        }
        if (tempList.size() > 0)
            tempList.remove(tempList.size() - 1);
    }

}

public class Q3 {

    public static void main(String[] args) {
        new Q3Solution().solve();
    }
}
