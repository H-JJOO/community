package dev.hjjoo.community.board;

import dev.hjjoo.community.Const;
import dev.hjjoo.community.MenuPreparer;
import dev.hjjoo.community.model.BoardDto;
import dev.hjjoo.community.model.BoardEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping("/list/{icategory}")
    public String list(@PathVariable int icategory, BoardDto dto, Model model) {
        model.addAttribute(Const.I_CATEGORY, icategory);
        model.addAttribute(Const.LIST, service.selBoardList(dto));
        dto.setIcategory(icategory);
        return "board/list";//본인이 본인거 여는거, 여기서 리다이렉트하면 무한루프
    }

    @GetMapping("/write")
    public void write() {}

    @PostMapping("/write")
    public String writeProc(BoardEntity entity, RedirectAttributes reAttr) {
        int result = service.insBoard(entity);
        if (result == 0) {
            reAttr.addFlashAttribute(Const.MSG, Const.ERR_5);
            reAttr.addAttribute(Const.DATA, entity);
            return "redirect:/board/write";
        }
        return "redirect:/board/list/" + entity.getIcategory();
    }
}
