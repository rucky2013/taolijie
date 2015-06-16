package com.fh.taolijie.controller.admin;

import com.fh.taolijie.domain.JobPostModel;
import com.fh.taolijie.domain.ResumeModel;
import com.fh.taolijie.service.ResumeService;
import com.fh.taolijie.utils.Constants;
import com.fh.taolijie.utils.ObjWrapper;
import com.fh.taolijie.utils.json.JsonWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by wynfrith on 15-6-11.
 */
@Controller
@RequestMapping("admin/resume")
public class AResumeController {

    @Autowired
    ResumeService resumeService;

    /**
     * 简历列表页面
     */
    @RequestMapping(value = "",method = RequestMethod.GET)
    public String jobs(Model model){
        int page = 1;
        int pageSize = 9999;
        ObjWrapper objWrapper = new ObjWrapper();
        List<ResumeModel> resumes;
        resumes =resumeService.getAllResumeList(page - 1, pageSize, objWrapper);

        int totalPage = (Integer) objWrapper.getObj();

        model.addAttribute("resumes", resumes);
        return "pc/admin/resumes";
    }

    /**
     * 删除用户的简历
     */
    @RequestMapping(value = "/del",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public @ResponseBody
    String deleteInfo(@RequestParam int id){
        ResumeModel resume=resumeService.findResume(id);

        if(!resumeService.deleteResume(id)){
            return new JsonWrapper(false, Constants.ErrorType.ERROR).getAjaxMessage();
        }

        return new JsonWrapper(true, Constants.ErrorType.SUCCESS).getAjaxMessage();

    }

}