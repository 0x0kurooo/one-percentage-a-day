class TimeValue {
    String val;
    int ts;

    TimeValue(String val, int ts) {
        this.val = val;
        this.ts = ts;
    }
}

class TimeMap {
    Map<String, List<TimeValue>> timeMap = new HashMap<>();

    public TimeMap() {}

    public void set(String key, String value, int timestamp) {
        List<TimeValue> timeValues = timeMap.computeIfAbsent(key, k -> new ArrayList<>());
        timeValues.add(new TimeValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> timeValues = timeMap.get(key);
        if (timeValues == null)
            return "";

        String res = "";
        int l = 0;
        int r = timeValues.size() - 1;
        while (l <= r) {
            int m = (l + r) / 2;
            if (timeValues.get(m).ts <= timestamp) {
                res = timeValues.get(m).val;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return res;
    }
}
