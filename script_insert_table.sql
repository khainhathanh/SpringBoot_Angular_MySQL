INSERT INTO `perfume`.`users`(`id_user`,`id_role`,`username`,`password`,`name`,`phone`,`email`,`address`) 
	VALUES (1,1,'user1','12345678','user1','09876543210','user1@gmail.com','25 Nguyễn Văn Cừ, Huế'),(2,2,'user2','12345678','user2','09876543210','user2@gmail.com','76 Nguyễn Chánh, Quảng Ngãi');

INSERT INTO `perfume`.`admin`(`id_admin`,`id_user`,`opt`) 
	VALUES(1,2,null);
    
INSERT INTO `perfume`.`trademarks`(`id_trademark`,`name`,`description`) 
	VALUES(1,'Helenvate','Thương hiệu Pháp'),
    (2,'Hansometer','Thương hiệu Italy');

INSERT INTO `perfume`.`perfumes`(`id_perfume`,`id_trademark`,`name`,`description`,`gender`,`origin`, `capacity`,`rating_level`) 
	VALUES 	(1,1,'sauvage','Hello savage',1,'Pháp','200',4),
			(2,2,'Hevalin Rose','Hello Hevalin',0,'Italy','200',3);

INSERT INTO `perfume`.`comments`(`id_comment`,`id_perfume`,`id_personcomment`,`email`,`name_commnet`,`description`,`create_date`,`create_update`) 
	VALUES(1,1,1,'user1@gmail.com','user1','aaaaaaaa','2022-12-01','2022-12-02');
    
INSERT INTO `perfume`.`customers`(`id_customer`,`id_user`,`level_usesystem`) 
	VALUES (1,1,1);
    
INSERT INTO `perfume`.`voschers`(`id_voscher`,`type_voscher`,`name_voscher`,`create_date`,`exp_date`) 
	VALUES(1,'Quà tặng','Tặng gấu bông 50000','2022-12-01','2023-05-06');
    
INSERT INTO `perfume`.`detail-voschers`(`id_voscher`,`id_customer`,`quantity`) 
	VALUES (1,1,1);
    
INSERT INTO `perfume`.`discount`(`id_discount`,`id_voscher`,`discount_value`) 
	VALUES (1,1,'30%');
    
INSERT INTO `perfume`.`gift`(`id_gift`,`id_voscher`,`name-voscher`,`cost`,`so-luong`) 
	VALUES(1,1,'Gấu bông',50000,1);
    
INSERT INTO `perfume`.`orders`(`id_order`,`id_customer`,`cost`,`status`) 
	VALUES (1,1,50000,1);
    
INSERT INTO `perfume`.`order-details`(`id_order`,`id_perfume`,`id_customer`,`name_customer`,`quantity`,`cost`,`status`) 
	VALUES (1,1,1,'Nguyễn Thành An',1,50000,1);
    
INSERT INTO `perfume`.`payments`(`id_payment`,`id_customer`,`id_order`,`name_customer`,`type_customer`,`phone`,`email`,`address`,`description`,`total_cost`,`deduction`,`gift`,`into_money`,`payment-method`) 
	VALUES(1,1,1,1,'thành viên','09876543210','user1@gmail.com','25 Nguyễn Văn Cừ','giao hàng trước 11:00',51000,500,'Gấu bông',50500,'chuyển khoản');

INSERT INTO `perfume`.`smells`(`id_smell`,`name`) 
	VALUES(1,'Gỗ' ),
    (2,'Hướng Dương' ),
    (3,'Cỏ Mục' );
    
INSERT INTO `perfume`.`perfume-smells`(`id_perfume`,`id_smell`,`quantity`,`cost`,`status`) 
	VALUES(1,1,1,100000,1),
		(2,1,1,1200000,0),
        (2,3,1,1300000,0),
        (2,2,1,1400000,0),
        (1,2,1,1500000,0),
        (1,3,1,1600000,0);
    
INSERT INTO `perfume`.`roles`(`id_role`,`name`) 
	VALUES (1,'Thành viên'),(2,'Quản trị viên');
    
INSERT INTO `perfume`.`voscher-orders`(`id_voscherorder`,`id_order`,`id_voscher`,`discount`,`gift`)
	VALUES (1,1,1,0,'Gấu bông');
    
INSERT INTO `perfume`.`carousel`(`id_carousel`,`img`,`alt`,`active`)
VALUES 	(1,'assets/caroulse-1.jpg','...',1),
		(2,'assets/caroulse-2.jpg','...',0),
		(3,'assets/caroulse-3.jpg','...',0);
        
INSERT INTO `perfume`.`menus`(`id_menu`,`name`) 
	VALUES 	(1,'Trang chủ'),
			(2,'Thương hiệu'),
			(3,'Nước hoa'),
			(4,'Kiến thức'),
			(5,'Blog'),
			(6,'Liên hệ');

INSERT INTO `perfume`.`menu-childs`(`id_childmenu`,`id_menu`,`name`) 
	VALUES (1,2,'savage'),
           (2,2,'anale'),
           (3,3,'rome');

INSERT INTO `perfume`.`role-menus`(`id_menu`,`id_role`,`isChild`)
	VALUES (1,1,0),
           (1,1,1),
           (2,1,1),
           (3,1,1),
           (2,1,0),
           (3,1,0),
           (4,1,0),
           (5,1,0),
           (6,1,0);
INSERT INTO `perfume`.`picture`(`id_picture`,`id_perfume`,`id_smell`,`picture_name`,`src`)
	VALUES (1,1,3,'','assets/sp1.jpg'),
    (2,1,1,'','assets/sp1.jpg'),
    (3,1,2,'','assets/sp1.jpg'),
    (4,2,1,'','assets/sp2.jpg'),
    (5,2,2,'','assets/sp2.jpg'),
    (6,2,3,'','assets/sp2.jpg'),
    (7,1,1,'','assets/sp1.jpg');
    

           



        

