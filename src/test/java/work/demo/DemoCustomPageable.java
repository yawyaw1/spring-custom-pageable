package work.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import work.CustomPageable;
import work.Loader;

import java.util.ArrayList;
import java.util.List;

public class DemoCustomPageable extends CustomPageable<Long, String> {

    private final int size;

    public DemoCustomPageable(int size) {
        this.size = size;
    }

    public Page<String> find(long index, Pageable pageable) {
        Loader<String> loader = () -> {
            List<String> list = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                list.add(String.valueOf((char) ('a' + i)));
            }

            return list;
        };

        return find(index, pageable, loader);
    }
}
