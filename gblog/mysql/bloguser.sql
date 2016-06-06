/*
    所有表使用InnoDB引擎
    表名统一使用驼峰命名法(所有首字母大写)
    字段全部小写
    布尔类型统一使用TINYINT(1)类型，0代表false，1代表true
    每个表有个deleted字段，可代表逻辑删除，插入数据时，默认为‘0’（表示可用）
    预留字段包含一个int类型和4个VARCHAR类型
*/

DROP DATABASE IF EXISTS blog_user;

CREATE DATABASE blog_user;

USE blog_user;

/*
    用户表
*/
CREATE TABLE User
(
    userId INT UNSIGNED NOT NULL AUTO_INCREMENT,        -- 用户ID
    username VARCHAR(128) NOT NULL UNIQUE,                     -- 用户名
    anonymous BOOLEAN NOT NULL DEFAULT 0,          -- 是否匿名
    deleted BOOLEAN NOT NULL DEFAULT FALSE,            -- 是否被删
    PRIMARY KEY(userid)
)ENGINE=InnoDB;

#测试值
INSERT INTO User(username) values('algo_lzw');

/*
    用户帐号管理和状态
*/
CREATE TABLE UserState
(
    userId INT UNSIGNED NOT NULL PRIMARY KEY,                    -- 用户ID
    password VARCHAR(256),                                  -- 登录密码
    regDate TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,   -- 注册日期
    regFromIp VARCHAR(128),                                 -- 注册IP地址
    online BOOLEAN NOT NULL default FALSE,                 -- 是否在线
    lastLoginTime DATETIME,                                 -- 上次登录日期
    lastLoginFromIp VARCHAR(128),                           -- 上次登录ip地址
    lastChangePsdDate DATETIME,                             -- 上次修改密码时间
    changePsdTimes SMALLINT UNSIGNED NOT NULL DEFAULT 0,    -- 总共修改密码次数
    lockedOut BOOLEAN NOT NULL DEFAULT FALSE,                -- 是否锁定(无法登录)
    lastLockoutDate DATETIME,                               -- 上次被锁日期
    lockedOutTimes SMALLINT UNSIGNED NOT NULL DEFAULT 0,      -- 被锁定的总次数
    approved BOOLEAN NOT NULL DEFAULT FALSE,               -- 帐号是否经过认证
    psdAttemptFailCount TINYINT UNSIGNED NOT NULL DEFAULT 0,-- 密码输入错误次数
    mobile VARCHAR(16),                                  -- 安全电话号码
    email VARCHAR(256),                                  -- 安全邮箱
    lockedOff BOOLEAN NOT NULL DEFAULT FALSE,                -- 帐号是否被注销
    lastLockOffDate DATETIME,                               -- 上次被注销时间
    remark VARCHAR(256),                                   -- 备注
    cn1 INT,
    cn2 VARCHAR(512),
    cn3 VARCHAR(512),
    cn4 VARCHAR(512),
    cn5 VARCHAR(512),
    CONSTRAINT fk_user_info FOREIGN KEY(userId) 
        REFERENCES User(userId)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
)ENGINE=InnoDB;

INSERT INTO UserState(userId,password,regFromIp,approved,mobile,email)
    SELECT u.userId,'luoziwei1993','192.168.1.145',true,'15122469871','algo_lzw@yahoo.com' 
    FROM User AS u LIMIT 1;

/*
    角色表
*/
CREATE TABLE Role
(
    roleId INT UNSIGNED NOT NULL AUTO_INCREMENT,
    rolename VARCHAR(128) NOT NULL,
    deleted BOOLEAN NOT NULL DEFAULT FALSE,
    remark VARCHAR(256),
    cn1 INT,
    cn2 VARCHAR(512),
    cn3 VARCHAR(512),
    cn4 VARCHAR(512),
    cn5 VARCHAR(512),
    PRIMARY KEY(roleid)
)ENGINE=InnoDB;
CREATE INDEX idx_role_name ON Role(rolename);

#测试值
insert into Role(rolename,remark) values('admin','top level');

/*
    用户角色表
*/
CREATE TABLE UserInRole
(
    userId INT UNSIGNED NOT NULL,
    roleId INT UNSIGNED NOT NULL,
    PRIMARY KEY(userId,roleId),
    CONSTRAINT fk_UserInRole_User FOREIGN KEY(userId) 
        REFERENCES User(userId) 
            ON UPDATE CASCADE
            ON DELETE RESTRICT,
    CONSTRAINT fk_UserInRole_Role FOREIGN KEY(roleId) 
        REFERENCES Role(roleId)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
)ENGINE=InnoDB;

insert into UserInRole(userId,roleId) 
	select ur.userId,ur.roleId 
	from (select userId,roleId from User join Role) as ur
	limit 1;

/*
    用户详细信息
*/
CREATE TABLE UserDetail
(
    showDetails BOOLEAN NOT NULL default TRUE,    -- 是否显示详细信息
    userId INT UNSIGNED NOT NULL PRIMARY KEY,
    nickname VARCHAR(128),                          -- 昵称
    motto VARCHAR(256),                             -- 座右铭
    sex CHAR(1),                                    -- 性别('w'或'm')
    birthday DATE,                                  -- 生日
    constellation VARCHAR(64),                      -- 星座
    address VARCHAR(256),                           -- 地址
    region VARCHAR(256),                            -- 地区(形如:中国 四川 成都)
    wechat VARCHAR(256),                            -- 微信号
    qq VARCHAR(64),                                 -- qq号
    portrait VARCHAR(256),                          -- 头像（记录路径）
    remark VARCHAR(256),                            -- 个人说明
    cn1 INT,
    cn2 VARCHAR(512),
    cn3 VARCHAR(512),
    cn4 VARCHAR(512),
    cn5 VARCHAR(512),
    CONSTRAINT fk_user_detail FOREIGN KEY(userId) 
        REFERENCES User(userid)
            ON UPDATE CASCADE
            ON DELETE RESTRICT
)ENGINE=InnoDB ;
CREATE INDEX idx_UserDetail_nickname ON UserDetail(nickname);

insert into UserDetail(userid,nickname,sex,birthday,constellation,region,wechat,qq)
	select userid,'little','m','1993-07-01','狮子座','中国 天津','algo_Luo','547281360' from User as u limit 1; 













