create table if not exists `huas-project-yangwp`.product
(
    id          int auto_increment
        primary key,
    name        varchar(255)         not null,
    description text                 null,
    price       decimal(10, 2)       not null,
    in_cart     tinyint(1) default 0 not null comment '是否在购物车中,0表示不在,1表示在',
    quantity    int        default 0 not null comment '购物车中的商品数量,如果商品不在购物车中,那么数量为0',
    created_at  datetime             not null,
    updated_at  datetime             not null,
    is_deleted  tinyint(1) default 0 not null
)
    charset = utf8mb3;

-- 创建user表
CREATE TABLE `user`
(
    `id`         int(11)       NOT NULL AUTO_INCREMENT,
    `username`   varchar(255)  NOT NULL,
    `password`   varchar(255)  NOT NULL,
    `location`   varchar(255),
    `created_at` datetime      NOT NULL,
    `updated_at` datetime      NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;



-- 创建cart_item表
CREATE TABLE `cart_item`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`     int(11)        NOT NULL,
    `product_id`  int(11)        NOT NULL,
    `quantity`    int(11)        NOT NULL DEFAULT '0' COMMENT '购物车中的商品数量',
    `created_at`  datetime       NOT NULL,
    `updated_at`  datetime       NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- 创建order表
CREATE TABLE `order`
(
    `id`          int(11)        NOT NULL AUTO_INCREMENT,
    `user_id`     int(11)        NOT NULL,
    `product_id`  int(11)        NOT NULL,
    `quantity`    int(11)        NOT NULL COMMENT '购买的商品数量',
    `is_deleted`  tinyint(1)     NOT NULL DEFAULT '0',
    `created_at`  datetime       NOT NULL,
    `updated_at`  datetime       NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    FOREIGN KEY (`product_id`) REFERENCES `product` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;