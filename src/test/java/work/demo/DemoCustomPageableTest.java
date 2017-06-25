package work.demo;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class DemoCustomPageableTest {

    @Test
    public void testTotal0Page0Size1Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(0);

        Pageable pageable = new PageRequest(0, 1, Sort.Direction.ASC, "stub");
        Page<String> page = cache.find(0, pageable);

        Assert.assertEquals(0, page.getTotalPages());
        Assert.assertEquals(0, page.getTotalElements());
        Assert.assertEquals(0, page.getNumber());
        Assert.assertEquals(1, page.getSize());
        Assert.assertEquals(0, page.getNumberOfElements());

        List<String> content = page.getContent();
        Assert.assertEquals(0, content.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal0Page1Size1Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(0);

        Pageable pageable = new PageRequest(1, 1, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal0Page0Size2Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(0);

        Pageable pageable = new PageRequest(0, 2, Sort.Direction.ASC, "stub");
        Page<String> page = cache.find(0, pageable);

        Assert.assertEquals(0, page.getTotalPages());
        Assert.assertEquals(0, page.getTotalElements());
        Assert.assertEquals(0, page.getNumber());
        Assert.assertEquals(2, page.getSize());
        Assert.assertEquals(0, page.getNumberOfElements());

        List<String> content = page.getContent();
        Assert.assertEquals(0, content.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal0Page1Size2Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(0);

        Pageable pageable = new PageRequest(1, 2, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal1Page0Size1Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(1);

        Pageable pageable1 = new PageRequest(0, 1, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(1, page1.getTotalPages());
        Assert.assertEquals(1, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(1, page1.getSize());
        Assert.assertEquals(1, page1.getNumberOfElements());

        List<String> content = page1.getContent();
        Assert.assertEquals(1, content.size());
        Assert.assertEquals("a", content.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal1Page1Size1Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(1);

        Pageable pageable = new PageRequest(1, 1, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal1Page0Size2Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(1);

        Pageable pageable1 = new PageRequest(0, 2, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(1, page1.getTotalPages());
        Assert.assertEquals(1, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(2, page1.getSize());
        Assert.assertEquals(1, page1.getNumberOfElements());

        List<String> content = page1.getContent();
        Assert.assertEquals(1, content.size());
        Assert.assertEquals("a", content.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal1Page1Size2Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(1);

        Pageable pageable = new PageRequest(1, 2, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal2Pages01Size1Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(2);

        Pageable pageable1 = new PageRequest(0, 1, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(2, page1.getTotalPages());
        Assert.assertEquals(2, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(1, page1.getSize());
        Assert.assertEquals(1, page1.getNumberOfElements());

        List<String> content1 = page1.getContent();
        Assert.assertEquals(1, content1.size());
        Assert.assertEquals("a", content1.get(0));

        Pageable pageable2 = new PageRequest(1, 1, Sort.Direction.ASC, "stub");
        Page<String> page2 = cache.find(0, pageable2);

        Assert.assertEquals(2, page2.getTotalPages());
        Assert.assertEquals(2, page2.getTotalElements());
        Assert.assertEquals(1, page2.getNumber());
        Assert.assertEquals(1, page2.getSize());
        Assert.assertEquals(1, page2.getNumberOfElements());

        List<String> content2 = page2.getContent();
        Assert.assertEquals(1, content2.size());
        Assert.assertEquals("b", content2.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal2Page2Size1Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(2);

        Pageable pageable = new PageRequest(2, 1, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal2Page0Size2Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(2);

        Pageable pageable1 = new PageRequest(0, 2, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(1, page1.getTotalPages());
        Assert.assertEquals(2, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(2, page1.getSize());
        Assert.assertEquals(2, page1.getNumberOfElements());

        List<String> content1 = page1.getContent();
        Assert.assertEquals(2, content1.size());
        Assert.assertEquals("a", content1.get(0));
        Assert.assertEquals("b", content1.get(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal2Page1Size2Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(2);

        Pageable pageable = new PageRequest(1, 2, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal3Pages012Size1Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(3);

        Pageable pageable1 = new PageRequest(0, 1, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(3, page1.getTotalPages());
        Assert.assertEquals(3, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(1, page1.getSize());
        Assert.assertEquals(1, page1.getNumberOfElements());

        List<String> content1 = page1.getContent();
        Assert.assertEquals(1, content1.size());
        Assert.assertEquals("a", content1.get(0));

        Pageable pageable2 = new PageRequest(1, 1, Sort.Direction.ASC, "stub");
        Page<String> page2 = cache.find(0, pageable2);

        Assert.assertEquals(3, page2.getTotalPages());
        Assert.assertEquals(3, page2.getTotalElements());
        Assert.assertEquals(1, page2.getNumber());
        Assert.assertEquals(1, page2.getSize());
        Assert.assertEquals(1, page2.getNumberOfElements());

        List<String> content2 = page2.getContent();
        Assert.assertEquals(1, content2.size());
        Assert.assertEquals("b", content2.get(0));

        Pageable pageable3 = new PageRequest(2, 1, Sort.Direction.ASC, "stub");
        Page<String> page3 = cache.find(0, pageable3);

        Assert.assertEquals(3, page3.getTotalPages());
        Assert.assertEquals(3, page3.getTotalElements());
        Assert.assertEquals(2, page3.getNumber());
        Assert.assertEquals(1, page3.getSize());
        Assert.assertEquals(1, page3.getNumberOfElements());

        List<String> content3 = page3.getContent();
        Assert.assertEquals(1, content3.size());
        Assert.assertEquals("c", content3.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal3Pages3Size2Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(3);

        Pageable pageable = new PageRequest(3, 2, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal3Pages01Size2Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(3);

        Pageable pageable1 = new PageRequest(0, 2, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(2, page1.getTotalPages());
        Assert.assertEquals(3, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(2, page1.getSize());
        Assert.assertEquals(2, page1.getNumberOfElements());

        List<String> content1 = page1.getContent();
        Assert.assertEquals(2, content1.size());
        Assert.assertEquals("a", content1.get(0));
        Assert.assertEquals("b", content1.get(1));

        Pageable pageable2 = new PageRequest(1, 2, Sort.Direction.ASC, "stub");
        Page<String> page2 = cache.find(0, pageable2);

        Assert.assertEquals(2, page2.getTotalPages());
        Assert.assertEquals(3, page2.getTotalElements());
        Assert.assertEquals(1, page2.getNumber());
        Assert.assertEquals(2, page2.getSize());
        Assert.assertEquals(1, page2.getNumberOfElements());

        List<String> content2 = page2.getContent();
        Assert.assertEquals(1, content2.size());
        Assert.assertEquals("c", content2.get(0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal3Pages2Size2Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(3);

        Pageable pageable = new PageRequest(2, 2, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }

    @Test
    public void testTotal3Page0Size3Ok() {
        DemoCustomPageable cache = new DemoCustomPageable(3);

        Pageable pageable1 = new PageRequest(0, 3, Sort.Direction.ASC, "stub");
        Page<String> page1 = cache.find(0, pageable1);

        Assert.assertEquals(1, page1.getTotalPages());
        Assert.assertEquals(3, page1.getTotalElements());
        Assert.assertEquals(0, page1.getNumber());
        Assert.assertEquals(3, page1.getSize());
        Assert.assertEquals(3, page1.getNumberOfElements());

        List<String> content1 = page1.getContent();
        Assert.assertEquals(3, content1.size());
        Assert.assertEquals("a", content1.get(0));
        Assert.assertEquals("b", content1.get(1));
        Assert.assertEquals("c", content1.get(2));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTotal3Page1Size3Exception() {
        DemoCustomPageable cache = new DemoCustomPageable(3);

        Pageable pageable = new PageRequest(1, 3, Sort.Direction.ASC, "stub");
        cache.find(0, pageable);
    }
}
