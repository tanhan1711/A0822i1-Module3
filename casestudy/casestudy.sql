use furama;
SET GLOBAL sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));
-- cau1 --

INSERT INTO vi_tri (ma_vi_tri, ten_vi_tri)
VALUE(1, 'Quản Lý'),
	 (2, 'Nhân Viên');
SELECT * FROM vi_tri;
     
INSERT INTO trinh_do (ma_trinh_do, ten_trinh_do)
VALUE(1, 'Trung Cấp'),
     (2, 'Cao Đẳng'),
     (3, 'Đại Học'),
     (4, 'Sau Đại Học');
SELECT * FROM trinh_do;
     
INSERT INTO bo_phan (ma_bo_phan, ten_bo_phan)
VALUE(1, 'Sale-Marketing'),
	 (2, 'Hành chính'),
     (3, 'Phục vụ'),
     (4, 'Quản lý');
SELECT * FROM bo_phan;
     
INSERT INTO nhan_vien
VALUE(1, 'Nguyễn Văn An', '1970-11-07',	'456231786', 10000000, '0901234121', 'annguyen@gmail.com', '295 Nguyễn Tất Thành, Đà Nẵng',	1, 3, 1),
     (2, 'Lê Văn Bình', '1997-04-09', '654231234', 7000000, '0934212314', 'binhlv@gmail.com', '22 Yên Bái, Đà Nẵng', 1, 2, 2),
     (3, 'Hồ Thị Yến', '1995-12-12', '999231723', 14000000, '0412352315', 'thiyen@gmail.com', 'K234/11 Điện Biên Phủ, Gia Lai', 1, 3, 2),
     (4, 'Võ Công Toản', '1980-04-04', '123231365', 17000000, '0374443232', 'toan0404@gmail.com', '77 Hoàng Diệu, Quảng Trị', 1, 4, 4),
     (5, 'Nguyễn Bỉnh Phát', '1999-12-09', '454363232', 6000000, '0902341231', 'phatphat@gmail.com', '43 Yên Bái, Đà Nẵng', 2, 1, 1),
     (6, 'Khúc Nguyễn An Nghi', '2000-11-08', '964542311', 7000000, '0978653213', 'annghi20@gmail.com', '294 Nguyễn Tất Thành, Đà Nẵng', 2, 2, 3),
     (7, 'Nguyễn Hữu Hà', '1993-01-01', '534323231', 8000000, '0941234553', 'nhh0101@gmail.com', '4 Nguyễn Chí Thanh, Huế', 2, 3, 2),
     (8, 'Nguyễn Hà Đông', '1989-09-03', '234414123', 9000000, '0642123111', 'donghanguyen@gmail.com', '111 Hùng Vương, Hà Nội', 2, 4, 4),
     (9, 'Tòng Hoang', '1982-09-03', '256781231', 6000000, '0245144444', 'hoangtong@gmail.com', '213 Hàm Nghi, Đà Nẵng', 2, 4, 4),
     (10, 'Nguyễn Công Đạo', '1994-01-08', '755434343', 8000000, '0988767111', 'nguyencongdao12@gmail.com', '6 Hoà Khánh, Đồng Nai', 2, 3, 2);
 SELECT * FROM nhan_vien;
 
INSERT INTO loai_khach (ma_loai_khach, ten_loai_khach)
VALUE(1, 'Diamond'),
     (2, 'Platinium'),
     (3, 'Gold'),
     (4, 'Silver'),
     (5, 'Member');
SELECT * FROM loai_khach;
     
INSERT INTO khach_hang
VALUE(1, 5, 'Nguyễn Thị Hào', '1970-11-07', 0, '643431213', '0945423362', 'thihao07@gmail.com', '23 Nguyễn Hoàng, Đà Nẵng'),
     (2, 3, 'Phạm Xuân Diệu', '1992-08-08', 1, '865342123', '0954333333', 'xuandieu92@gmail.com', 'K77/22 Thái Phiên, Quảng Trị'),
     (3, 1, 'Trương Đình Nghệ', '1990-02-27', 1, '488645199', '0373213122', 'nghenhan2702@gmail.com', 'K323/12 Ông Ích Khiêm, Vinh'),
     (4, 1, 'Dương Văn Quan', '1981-07-08', 1, '543432111', '0490039241', 'duongquan@gmail.com', 'K453/12 Lê Lợi, Đà Nẵng'),
     (5, 4, 'Hoàng Trần Nhi Nhi', '1995-12-09', 0, '795453345', '0312345678', 'nhinhi123@gmail.com', '224 Lý Thái Tổ, Gia Lai'),
     (6, 4, 'Tôn Nữ Mộc Châu', '2005-12-06', 0, '732434215', '0988888844', 'tonnuchau@gmail.com', '37 Yên Thế, Đà Nẵng'),
     (7, 1, 'Nguyễn Mỹ Kim', '1984-04-08', 0, '856453123', '0912345698', 'kimcuong84@gmail.com', 'K123/45 Lê Lợi, Hồ Chí Minh'),
     (8, 3, 'Nguyễn Thị Hào', '1999-04-08', 0, '965656433', '0763212345', 'haohao99@gmail.com', '55 Nguyễn Văn Linh, Kon Tum'),
     (9, 1, 'Trần Đại Danh', '1994-07-01', 1, '432341235', '0643343433', 'danhhai99@gmail.com', '24 Lý Thường Kiệt, Quảng Ngãi'),
     (10, 2, 'Nguyễn Tâm Đắc', '1989-07-01', 1, '344343432', '0987654321', 'dactam@gmail.com', '22 Ngô Quyền, Đà Nẵng');
SELECT * FROM khach_hang;
     
INSERT INTO kieu_thue (ma_kieu_thue, ten_kieu_thue)
VALUE(1, 'year'),
     (2, 'month'),
     (3, 'day'),
     (4, 'hour');
SELECT * FROM kieu_thue;
     
INSERT INTO loai_dich_vu (ma_loai_dich_vu, ten_loai_dich_vu)
VALUE(1, 'Villa'),
     (2, 'House'),
     (3, 'Room');
SELECT * FROM loai_dich_vu;
    
INSERT INTO dich_vu
VALUE(1, 'Villa Beach Front', 25000, 10000000, 10, 3, 1, 'vip', 'Có hồ bơi', 500, 4),
     (2, 'House Princess 01', 14000, 5000000, 7, 2, 2, 'vip', 'Có thêm bếp nướng', null, 3),
     (3, 'Room Twin 01', 5000, 1000000, 2, 4, 3, 'normal', 'Có tivi', null, null),
     (4, 'Villa No Beach Front', 22000, 9000000, 8, 3, 1, 'normal', 'Có hồ bơi', 300, 3),
     (5, 'House Princess 02', 10000, 4000000, 5, 3, 2, 'normal', 'Có thêm bếp nướng', null, 2),
     (6, 'Room Twin 02', 3000, 900000, 2, 4, 3, 'normal', 'Có tivi', null, null);
SELECT * FROM dich_vu;

INSERT INTO dich_vu_di_kem
VALUE(1, 'Karaoke', 10000, 'giờ', 'tiện nghi, hiện tại'),
     (2, 'Thuê xe máy', 10000, 'chiếc', 'hỏng 1 xe'),
     (3, 'Thuê xe đạp', 20000, 'chiếc', 'tốt'),
     (4, 'Buffet buổi sáng', 15000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (5, 'Buffet buổi trưa', 90000, 'suất', 'đầy đủ đồ ăn, tráng miệng'),
     (6, 'Buffet buổi tối', 16000, 'suất', 'đầy đủ đồ ăn, tráng miệng');
SELECT * FROM dich_vu_di_kem;
     
INSERT INTO hop_dong
VALUE(1, '2020-12-08', '2020-12-08', 0, 3, 1, 3),
     (2, '2020-07-14', '2020-07-21', 200000, 7, 3, 1),
     (3, '2021-03-15', '2021-03-17', 50000, 3, 4, 2),
     (4, '2021-01-14', '2021-01-18', 100000, 7, 5, 5),
     (5, '2021-07-14', '2021-07-15', 0, 7, 2, 6),
     (6, '2021-06-01', '2021-06-03', 0, 7, 7, 6),
     (7, '2021-09-02', '2021-09-05', 100000, 7, 4, 4),
     (8, '2021-06-17', '2021-06-18', 150000, 3, 4, 1),
     (9, '2020-11-19', '2020-11-19', 0, 3, 4, 3),
     (10, '2021-04-12', '2021-04-14', 0, 10, 3, 5),
     (11, '2021-04-25', '2021-04-25', 0, 2, 2, 1),
     (12, '2021-05-25', '2021-05-27', 0, 7, 10, 1);
SELECT * FROM hop_dong;
     
INSERT INTO hop_dong_chi_tiet
VALUE(1,  2, 4, 5),
     (2, 2, 5, 8),
     (3, 2, 6, 15),
     (4, 3, 1, 1),
     (5, 3, 2, 11),
     (6, 1, 3, 1),
     (7, 1, 2, 2),
     (8, 12, 2, 2);
SELECT * FROM hop_dong_chi_tiet;

-- cau2 ---
select * from nhan_vien
where substring_index(ho_ten,' ',-1) like 'h%'
or substring_index(ho_ten,' ',-1) like 'k%'
or substring_index(ho_ten,' ',-1) like 't%'
and length(ho_ten) <= 15;

-- cau3 ---
select *  from khach_hang 
where datediff(now(),ngay_sinh)/365 between 18 and 50 and (dia_chi like '%Quảng Trị%' or dia_chi like '%Đà Nẵng%');
-- cau4 ---
select kh.ma_khach_hang,ho_ten , count(kh.ma_khach_hang) 'so lan dat' from khach_hang kh join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach
where ten_loai_khach = 'Diamond'
group by kh.ma_khach_hang,ho_ten
order by count(kh.ma_khach_hang) ;

-- cau5 ---
select kh.ma_khach_hang,kh.ho_ten,lk.ten_loai_khach,hd.ma_hop_dong,dv.ten_dich_vu,hd.ngay_lam_hop_dong,hd.ngay_ket_thuc,sum(dv.chi_phi_thue+(hdct.so_luong+dvdk.gia))
from khach_hang kh
     join loai_khach lk on kh.ma_loai_khach = lk.ma_loai_khach 
     join hop_dong hd on kh.ma_khach_hamg = hd.ma_khach_hamg
     join dich_vu dv on dv.ma_dich_vu = hd.ma_dich_vu 
     join hop_dong_chi_tiet hdct on hdct.ma_hop_dong = hd.ma_hop_dong
     join dich_vu_di_kem dvdk on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem
     join (
     SELECT
            kh.ma_khach_hang as 'ma_khach_hang',
            sum(dv.chi_phi_thue+(hdct.so_luong+dvdk.gia)) as gia_dv
        from
            khach_hang kh, hop_dong_chi_tiet hdtc,dich_vu_di_kem dvdk
            join hop_dong hd USING (ma_khach_hang)
            join dich_vu dv USING (ma_dich_vu)
        GROUP by
            kh.ma_khach_hang
    ) tmp USING (ma_khach_hang)
GROUP by
    kh.ma_khach_hang;
-- cau6 ---
select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu not in ( select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where month (ngay_lam_hop_dong) between 1 and 3);

-- cau7 --
select dv.ma_dich_vu,dv.ten_dich_vu,dv.dien_tich,dv.chi_phi_thue,ldv.ten_loai_dich_vu
from dich_vu dv join loai_dich_vu ldv on dv.ma_loai_dich_vu = ldv.ma_loai_dich_vu
where dv.ma_dich_vu in ( select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where year (ngay_lam_hop_dong) = 2020)
and dv.ma_dich_vu not in (select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where year (ngay_lam_hop_dong) = 2021);

-- cau 8--

SELECT DISTINCT ho_ten
FROM khach_hang;

-- cau9 --
select month(ngay_lam_hop_dong) , ifnull((kh.ma_khach_hang),0)'so luong' from
khach_hang kh right join hop_dong hd on kh.ma_khach_hang = hd.ma_hop_dong
group by month(ngay_lam_hop_dong) 
order by month(ngay_lam_hop_dong) ;

-- cau10---
select hd.ma_hop_dong,ngay_lam_hop_dong,ngay_ket_thuc,tien_dat_coc,sum(so_luong)
from hop_dong hd left join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
group by hd.ma_hop_dong;

-- cau11

SELECT
    ma_dich_vu_di_kem,
    ten_dich_vu_di_kem
from
    dich_vu_di_kem
    JOIN hop_dong_chi_tiet USING (ma_dich_vu_di_kem)
    JOIN hop_dong hd USING (ma_hop_dong)
    JOIN khach_hang USING (ma_khach_hang)
    JOIN loai_khach USING (ma_loai_khach)
WHERE
    ten_loai_khach = 'Diamond'
    and (
        dia_chi like '%Vinh%'
        or dia_chi like '%Quang Ngai%'
    );
    
    -- cau12--
    select hd.ma_hop_dong,nv.ho_ten,kh.ho_ten,kh.so_dien_thoai,ten_dich_vu,sum(so_luong),tien_dat_coc
    from hop_dong hd join nhan_vien nv on hd.ma_nhan_vien = nv.ma_nhan_vien
    join  khach_hang kh on kh.ma_khach_hang = hd.ma_khach_hang
    join hop_dong_chi_tiet hdct on hd.ma_hop_dong = hdct.ma_hop_dong
    join dich_vu dv on hd.ma_dich_vu = dv.ma_dich_vu
    where dv.ma_dich_vu in ( select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where  month(ngay_lam_hop_dong) between 10 and 12 and ( year(ngay_lam_hop_dong) = 2020))
    and dv.ma_dich_vu not in(select dv.ma_dich_vu from dich_vu dv join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
where  month(ngay_lam_hop_dong) between 1 and 6 and ( year(ngay_lam_hop_dong) = 2021));
    
    -- cau13 --
    select ma_dich_vu_di_kem , ten_dich_vu_di_kem ,sum(so_luong) 'so_luong_dich_vu_di_kem'
from khach_hang kh
join hop_dong using (ma_khach_hang)
join hop_dong_chi_tiet hdct using (ma_hop_dong)
join dich_vu_di_kem dvdk using (ma_dich_vu_di_kem)
group by ma_dich_vu_di_kem
having so_luong_dich_vu_di_kem = ALL (
select Max(s.so_luong_dich_vu_di_kem)
from (select ma_dich_vu_di_kem , ten_dich_vu_di_kem ,sum(so_luong) 'so_luong_dich_vu_di_kem'
from khach_hang kh
join hop_dong using (ma_khach_hang)
join hop_dong_chi_tiet hdct using (ma_hop_dong)
join dich_vu_di_kem dvdk using (ma_dich_vu_di_kem)
group by ma_dich_vu_di_kem)s);
    
    
    -- cau 14 --
    select ma_hop_dong,ten_loai_dich_vu, ten_dich_vu_di_kem, count(ma_dich_vu_di_kem) 'so_lan_su_dung'
    from hop_dong hd join dich_vu dv using(ma_dich_vu)
    join loai_dich_vu ldv using(ma_loai_dich_vu)
    join hop_dong_chi_tiet hdct using(ma_hop_dong)
    join dich_vu_di_kem dvdk using(ma_dich_vu_di_kem)
    group by ma_dich_vu_di_kem
    having count(ma_dich_vu_di_kem) = 1;

-- cau 15---

select ma_nhan_vien, ho_ten,ten_trinh_do, ten_bo_phan, so_dien_thoai, dia_chi
from nhan_vien join trinh_do using (ma_trinh_do)
join bo_phan using (ma_bo_phan)
join hop_dong using (ma_nhan_vien)
where year(ngay_lam_hop_dong) between 2020 and 2021
group by ma_nhan_vien
having count(ma_hop_dong) <=3;

-- cau 16 ---
delete from nhan_vien nv where not exists (select * from hop_dong 
where nv.ma_nhan_vien=ma_nhan_vien and  year (ngay_lam_hop_dong) between 2019 and 2021) ;

-- cau 17 --
UPDATE
    khach_hang
set
    ma_loai_khach = 1
WHERE
    ma_khach_hang in (
        select
            t.ma_khach_hang
        from
            (
                SELECT
                    kh.ma_khach_hang,
                    kh.ho_ten,
                    lk.ten_loai_khach,
                    hd.ma_hop_dong,
                    dv.ten_dich_vu,
                    hd.ngay_lam_hop_dong,
                    hd.ngay_ket_thuc,
                    (sum(dvdk.gia * hdct.so_luong) + tmp.gia_dv) tong_tien
                FROM
                    khach_hang kh
                    left JOIN loai_khach lk USING (ma_loai_khach)
                    left join hop_dong hd USING (ma_khach_hang)
                    left join dich_vu dv USING (ma_dich_vu)
                    left JOIN hop_dong_chi_tiet hdct USING (ma_hop_dong)
                    left join dich_vu_di_kem dvdk USING (ma_dich_vu_di_kem)
                    left JOIN (
                        SELECT
                            kh.ma_khach_hang as ma_khach_hang,
                            sum(dv.chi_phi_thue) as gia_dv
                        from
                            khach_hang kh
                            join hop_dong hd USING (ma_khach_hang)
                            join dich_vu dv USING (ma_dich_vu)
                        GROUP by
                            kh.ma_khach_hang
                    ) as tmp USING (ma_khach_hang)
                where
                    ten_loai_khach = 'Platinium'
                GROUP by
                    kh.ma_khach_hang
                HAVING
                    tong_tien > 1000000
            ) t
    );
-- 18--
delete khach_hang , hop_dong , hop_dong_chi_tiet from khach_hang kh join hop_dong using (ma_khach_hang)
join hop_dong_chi_tiet using(ma_hop_dong)
where not exists (select hd.ma_hop_dong where year(ngay_lam_hop_dong)< 2021);

-- cau 19--
update dich_vu_di_kem
set gia = gia * 2
where 
ma_dich_vu_di_kem in (select dvdk.ma_dich_vu_di_kem from (select ma_dich_vu_di_kem,sum(so_luong) t from 
dich_Vu join hop_dong using (ma_dich_vu)
join hop_dong_chi_tiet using (ma_hop_dong)
group by ma_dich_vu_di_kem
having t>10) dvdk);            
-- cau 20 --
SELECT
    ma_nhan_vien as id,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    nhan_vien
UNION ALL
SELECT
    ma_khach_hang,
    ho_ten,
    email,
    so_dien_thoai,
    ngay_sinh,
    dia_chi
FROM
    khach_hang;
