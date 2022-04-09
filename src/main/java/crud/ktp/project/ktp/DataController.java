package crud.ktp.project.ktp;


import java.util.ArrayList;
import java.util.List;
import javax.xml.crypto.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Asus
 */
@Controller
public class DataController {
    
    DataJpaController datactrl = new DataJpaController();
    List<Data> newdata = new ArrayList<>();
    
    @RequestMapping("/main")
    public String getMain(){
        return "menu";
    }
    
    @RequestMapping("/data")
    @ResponseBody
    public List<Data> getDataKTP(Model model){
        int record = datactrl.getDataCount();
        try{
            newdata = datactrl.findDataEntities(0, record);
        }
        catch(Exception e){}
        model.addAttribute("goData", newdata);
        
        return newdata;
    }
    
    @RequestMapping("/edit")
    public String doEdit(){
        return "editktp";
    }
}