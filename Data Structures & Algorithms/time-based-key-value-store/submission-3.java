class Data {
    String val;
    int ts;

    Data(String val, int ts) {
        this.val = val;
        this.ts = ts;
    }
}

class TimeMap {
    Map<String, List<Data>> dataStore = new HashMap<>();

    public TimeMap() {}
    
    public void set(String key, String value, int timestamp) {
        List<Data> data = dataStore.computeIfAbsent(key, k -> new ArrayList<>());
        data.add(new Data(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Data> data = dataStore.computeIfAbsent(key, k -> new ArrayList<>());
        String res = "";
        int l = 0;
        int r = data.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (data.get(m).ts <= timestamp) {
                res = data.get(m).val;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
