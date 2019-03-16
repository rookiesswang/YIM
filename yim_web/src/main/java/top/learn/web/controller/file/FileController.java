package top.learn.web.controller.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import top.learn.common.CommonConst;
import top.learn.common.Result;
import top.learn.common.ResultStatus;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("/file")
@Controller
public class FileController {

    public static Logger log = LoggerFactory.getLogger(FileController.class);

    @ResponseBody
    @RequestMapping(value = "/fileUpload",method = RequestMethod.POST)
    public Result fileUpload(@RequestParam(value = "file") MultipartFile file) {
        if (file.isEmpty()) {
            System.out.println("文件为空");
        }
        Result result = new Result(ResultStatus.Error);
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = CommonConst.IMG_LOCATION_WINDOWS; // 上传后的路径
        log.info("文件存放路径为：" + filePath);
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        log.info("文件名为：" + fileName);
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            result.setStatus(ResultStatus.Success);
            result.setMsg("上传文件成功!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "avatar//"  + fileName;
        log.info("保存文件路徑爲：" + filename);
        result.setData(filename);
        return result;
    }

}
