    CREATE TABLE `product`
    (
        `id`          int(11)        NOT NULL AUTO_INCREMENT,
        `name`        varchar(255)   NOT NULL,
        `description` text,
        `price`       decimal(10, 2) NOT NULL,
        `in_cart`     tinyint(1)     NOT NULL DEFAULT '0' COMMENT '是否在购物车中,0表示不在,1表示在',
        `quantity`    int(11)        NOT NULL DEFAULT '0' COMMENT '购物车中的商品数量,如果商品不在购物车中,那么数量为0',
        `created_at`  datetime       NOT NULL,
        `updated_at`  datetime       NOT NULL,
        `is_deleted`  tinyint(1)     NOT NULL DEFAULT '0',
        PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
      DEFAULT CHARSET = utf8;

use `huas-project-yangwp`;
INSERT INTO `product`
(`name`, `description`, `price`, `in_cart`, `quantity`, `created_at`, `updated_at`, `is_deleted`)
VALUES ('iPhone 14', 'Apples latest phone', 7999.99, 0, 0, NOW(), NOW(), 0),
       ('MacBook Pro', 'High performance laptop', 12999.99, 0, 0, NOW(), NOW(), 0),
       ('iPad Pro', 'Most advanced iPad', 6999.99, 0, 0, NOW(), NOW(), 0),

       ('T-shirt', 'Plain black t-shirt', 99.99, 0, 0, NOW(), NOW(), 0),
       ('Jeans', 'Blue denim jeans', 199.99, 0, 0, NOW(), NOW(), 0),
       ('Socks', 'Plain black socks', 9.99, 0, 0, NOW(), NOW(), 0),


       ('Milk', 'Full cream milk, 2L', 15.99, 0, 0, NOW(), NOW(), 0),
       ('Bread', 'Wholemeal sandwich loaf', 4.99, 0, 0, NOW(), NOW(), 0),
       ('Eggs', 'Free range eggs, dozen', 4.99, 0, 0, NOW(), NOW(), 0),

       ('Apples', 'Granny Smith apples, bag', 4.99, 0, 0, NOW(), NOW(), 0),
       ('Bananas', 'Cavendish bananas, bunch', 2.99, 0, 0, NOW(), NOW(), 0),
       ('Blueberries', 'Fresh blueberries, 125g', 3.99, 0, 0, NOW(), NOW(), 0);

select * from `product`;