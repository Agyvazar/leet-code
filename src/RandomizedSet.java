import java.util.*;

public class RandomizedSet {

    List<Integer> dta = new ArrayList<>();
    Map<Integer, Integer> idx = new HashMap<>();

    public RandomizedSet() {
    }

    public boolean insert(Integer item) {
        if (idx.containsKey(item)) {
            return false;
        }
        idx.put(item, dta.size());
        dta.add(item);
        return true;
    }

    public boolean remove(Integer item) {
        Integer id = idx.get(item);
        if (id == null) {
            return false;
        }
        removeAt(id);
        return true;
    }

    private void removeAt(Integer id) {
        if (id > dta.size()) {
            return;
        }
        Integer item = dta.get(id);
        idx.remove(item);

        Integer last = dta.remove(dta.size() - 1);
        if (id < dta.size()) {
            idx.put(last, id);
            dta.set(id, last);
        }
    }

    public Integer getRandom() {
        if (dta.isEmpty()) {
            return null;
        }
        int i = new Random().nextInt(dta.size());
        return dta.get(i);
    }
}