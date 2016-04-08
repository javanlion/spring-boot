package sample.freemarker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Controller
public class WelcomeController {

    private static final String PARAM_SHOW_ROWS = "showRows";
    @Value("${application.message:Hello World}")
    private String message = "Hello World";

    @RequestMapping("/")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);
        return "welcome";
    }

    @RequestMapping("/list")
    public String welcomeList(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);

        File folder = new File("D:\\var\\log\\valuation");
        File[] files = folder.listFiles();
        List<String> strings = new ArrayList<>();
        for (File file : files) {
            if (file.isFile()) {
                strings.add(file.getName());
            }
        }

        model.put("list", strings);
        return "list";
    }

    @RequestMapping("/map")
    public String welcomeMap(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", this.message);

        File folder = new File("D:\\var\\log\\valuation");
        File[] files = folder.listFiles();
        Map<String, String> map = new LinkedHashMap<>();

        for (File file : files) {
            if (file.isFile()) {
                map.put(file.getName(), file.getAbsolutePath());
            }
        }

        model.put("map", map);
        return "map";
    }

    @RequestMapping("/pagination")
    public String welcomePagination(Map<String, Object> model,
                                    @RequestParam(value = PARAM_SHOW_ROWS, required = false) String showRows
                                    /*@RequestParam Map<String, String> allRequestParams*/) {
        model.put("time", new Date());
        model.put("message", this.message);

        File folder = new File("C:\\Windows");
        File[] files = folder.listFiles();
        Map<String, String> map = new LinkedHashMap<>();
//		String showRows = allRequestParams.get(PARAM_SHOW_ROWS);
        Integer limit = showRows == null || "All".equals(showRows) ? Integer.MAX_VALUE : Integer.parseInt(showRows);

        if (files != null) {
            for (int i = 0; map.size() < limit && i < files.length; i++) {
                if (files[i].isFile()) {
                    map.put(files[i].getName(), files[i].getAbsolutePath());
                }
            }
        }

//		model.putAll(allRequestParams);
        model.put(PARAM_SHOW_ROWS, showRows);
        model.put("map", map);
        return "paginationExample";
    }

/*	@RequestMapping("/download")
	public String showFile(@RequestParam("foo") String foo, Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);

		File folder = new File("D:\\var\\log\\valuation");
		File[] files = folder.listFiles();
		List<String> strings = new ArrayList<>();
		for (File file : files) {
			if (file.isFile()) {
				strings.add(file.getName());
			}
		}

		model.put("list", strings);
		return "list";
	}*/

}
