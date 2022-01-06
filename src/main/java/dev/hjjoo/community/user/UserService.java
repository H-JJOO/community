package dev.hjjoo.community.user;

import dev.hjjoo.community.model.UserEntity;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserMapper mapper;

    @Autowired
    private HttpSession hs;

    //아이디가 없으면 리턴 1, 있으면 리턴 0
    public int idChk(String uid) {
        UserEntity entity = new UserEntity();
        entity.setUid(uid);

        UserEntity result = mapper.selUser(entity);

        return result == null ? 1 : 0;
    }

    public int join(UserEntity entity) {
        String hashPw = BCrypt.hashpw(entity.getUpw(), BCrypt.gensalt());
        entity.setUpw(hashPw);
        int result = mapper.insUser(entity);
        return result;
    }

    public int login(UserEntity entity) {
        UserEntity loginUser = null;
        try{
            loginUser = mapper.selUser(entity);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;//에러
        }
        if (loginUser == null) {
            return 2;//아이디 없음
        }
        if (BCrypt.checkpw(entity.getUpw(),loginUser.getUpw())) {
            loginUser.setUpw(null);
            loginUser.setRdt(null);
            hs.setAttribute("loginUser", loginUser.getIuser());
            return 1;//아이디있고, 비밀번호 맞음
        }
        return 3;//비밀번호 틀림
    }



}
