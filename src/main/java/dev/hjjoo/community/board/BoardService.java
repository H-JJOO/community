package dev.hjjoo.community.board;

import dev.hjjoo.community.UserUtils;
import dev.hjjoo.community.model.BoardDto;
import dev.hjjoo.community.model.BoardEntity;
import dev.hjjoo.community.model.BoardVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper mapper;

    @Autowired
    private UserUtils userUtils;

    public int insBoard(BoardEntity entity) {
        int result = 0;
        try {
            entity.setIuser(userUtils.getLoginUserPk());
            result = mapper.insBoard(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public List<BoardVo> selBoardList(BoardDto dto) {
        return mapper.selBoardList(dto);
    }
}
