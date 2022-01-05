package dev.hjjoo.community.user;

import dev.hjjoo.community.model.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    UserEntity selUser(UserEntity entity);
}
