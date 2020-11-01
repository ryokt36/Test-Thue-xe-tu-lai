create database Thue_xe_tu_lai

IF Object_ID('TINHNANG') is not null 
	drop table TINHNANG 
GO 
create table TINHNANG
(
  id				int identity(1,1) not null,
  tentinhnang		nvarchar(100) unique null,
  constraint PK_TINHNANG primary key (id)
)

IF Object_ID('CANCUOCCONGDAN') is not null 
	drop table CANCUOCCONGDAN 
GO 
create table CANCUOCCONGDAN
(
  id					int identity(1,1) not null,
  so					varchar(20) unique not null,
  noicap				nvarchar(max) not null,
  ngaycap				date not null,
  anh					nvarchar null,
  trangthai				char(1) not null,
  constraint PK_CANCUOCCONGDAN primary key (id)
)

IF Object_ID('NGUOIDUNG') is not null 
	drop table NGUOIDUNG 
GO 
create table NGUOIDUNG
(
  id					int identity(1,1) not null,
  taikhoan				varchar(25) unique not null,
  matkhau				varchar(max) not null,
  hoten					nvarchar(255) not null,
  gioitinh				nvarchar(10) not null,
  hokhau				varchar(300) null,
  anhdaidien			varchar null,
  sdt					varchar(100) null,
  diachi				varchar(max) null,
  email					varchar(50) not null,
  id_cccd				int null,	
  blx					varchar(300) null,	
  chucvu				char(1) not null,
  isDelete				bit null,
  constraint PK_NGUOIDUNG primary key (id),
  constraint FK_CANCUOCCONGDAN_NGUOIDUNG foreign key (id_cccd) references CANCUOCCONGDAN
)

IF Object_ID('HANGXE') is not null 
	drop table HANGXE 
GO 
create table HANGXE
(
  [id]			int identity(1,1) not null,
  [tenhang]		varchar(50) unique not null,
  constraint PK_HANGXE primary key (id),
)

IF Object_ID('MAUXE') is not null 
	drop table MAUXE 
GO 
create table MAUXE
(
  [id]			int identity(1,1) not null,
  [tenmau]		varchar(50) unique not null,
  [id_hangxe]	int not null,
  constraint PK_MAUXE primary key (id),
  constraint FK_HANGXE_MAUXE foreign key (id_hangxe) references HANGXE
)

IF Object_ID('XE') is not null 
	drop table XE 
GO 
create table XE
(
  id					int identity(1,1) not null,
  sokhung				varchar(20) unique not null,
  loaixe				nvarchar(20) not null,
  id_mauxe				int not null,
  anh					nvarchar(300) null,
  giathue				float not null,
  biensoxe				varchar(20) not null,		
  loainhienlieu			nvarchar(20) null,
  muctieuthu			float null,
  bodandong				nvarchar(50) null,
  loaihopso				nvarchar(50) null,
  dangkiem				varchar(300) null,
  dangky				varchar(300) null,
  mota					nvarchar(300) null,
  trangthai				nvarchar(100) null,
  [isDelete]			bit null,
  constraint PK_XE primary key (id),
  constraint FK_MAUXE_XE foreign key (id_mauxe) references MAUXE
)

IF Object_ID('HOPDONG') is not null 
	drop table HOPDONG 
GO 
create table HOPDONG
(
  id				int identity(1,1) not null,  
  id_xe				int not null,
  id_nguoithue		int not null,
  tenhopdong		varchar(100) not null,
  linkhopdong		varchar(300) null,
  constraint PK_HOPDONG primary key (id),
  constraint FK_XE_HOPDONG foreign key (id_xe) references XE,
  constraint FK_NGUOIDUNG_HOPDONG foreign key (id_nguoithue) references NGUOIDUNG
)

IF Object_ID('HOADON') is not null 
	drop table HOADON 
GO 
create table HOADON
(
  id			int identity(1,1) not null,
  id_nguoidung	int not null,
  ngaytao		date not null,
  tongtien		float not null,
  constraint PK_HOADON primary key (id),
  constraint FK_NGUOIDUNG_HOADON foreign key (id_nguoidung) references NGUOIDUNG
)

IF Object_ID('TINHNANGXE') is not null 
	drop table TINHNANGXE 
GO 
create table TINHNANGXE
(
  id_tinhnang	int not null,
  id_xe		int not null,
  constraint PK_XE_TINHNANG primary key (id_tinhnang, id_xe) ,
  constraint FK_TINHNANG_TINHNANGXE foreign key (id_tinhnang) references TINHNANG,
  constraint FK_XE_TINHNANGXE foreign key (id_xe) references XE
)

IF Object_ID('HOADONCHITIET') is not null 
	drop table HOADONCHITIET 
GO 
create table HOADONCHITIET
(
  id_hoadon		int not null,
  id_xe			int not null,
  ngaybatdau	date not null,
  ngayketthuc	date not null,
  tongtien		float not null,
  ghichu		nvarchar(300) null,
  isDelete		bit null,
  constraint PK_HOADONCHITIET primary key (id_hoadon, id_xe),
  constraint FK_HOADON_HOADONCHITIET foreign key (id_hoadon) references HOADON,
  constraint FK_XE_HOADONCHITIET foreign key (id_xe) references XE
)


---Them du lieu

Delete from NGUOIDUNG
DBCC CHECKIDENT ('NGUOIDUNG', RESEED, 0) --Reset Identity
Insert into NGUOIDUNG values ('longlhph07985', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', N'Hoàng Long','Nam', null, null, '0987654321', 'Time City', 'longlhph07985@fpt.edu.vn', null, null, 'S', null)
Insert into NGUOIDUNG values ('thanhpkph07933', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', N'Khắc Thanh','Nam', null, null, '0987654321', 'Thanh Hoa', 'thanhpkph07933@fpt.edu.vn', null, null, 'A', null)
Insert into NGUOIDUNG values ('lucntph07957', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', N'Tiến Lưc','Nam', null, null, '0987654321', 'Ha Noi', 'lucntph07957@fpt.edu.vn', null, null, 'S', null)
Insert into NGUOIDUNG values ('longnpph08645', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', 'Phi Long','Nam', null, null, '0987654321', 'Ha Noi', 'longnpph08645@fpt.edu.vn', null, null, 'A', null)
Insert into NGUOIDUNG values ('admin', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', 'Phi Long','Nam', null, null, '0987654321', 'Ha Noi', 'longnpph08645@fpt.edu.vn', null, null, 'A', null)
Insert into NGUOIDUNG values ('member', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', 'Phi Long','Nam', null, null, '0987654321', 'Ha Noi', 'longnpph08645@fpt.edu.vn', null, null, 'S', null)
Insert into NGUOIDUNG values ('member1', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', 'Phi Long','Nam', null, null, '0987654321', 'Ha Noi', 'longnpph08645@fpt.edu.vn', null, null, 'S', 1)
Insert into NGUOIDUNG values ('customer', '$2a$10$Q6nSXpwD6VVHmyoY96VubuGDJbYe6hM9enRiES8GS9OKGmW4jIjai', 'Phi Long','Nam', null, null, '0987654321', 'Ha Noi', 'longnpph08645@fpt.edu.vn', null, null, 'C', null)

Delete from TINHNANG
DBCC CHECKIDENT ('TINHNANG', RESEED, 0) --Reset Identity
Insert into TINHNANG values ('GPS')
Insert into TINHNANG values (N'Bản đồ')
Insert into TINHNANG values (N'Camera lùi')
Insert into TINHNANG values (N'Bluetooth')
Insert into TINHNANG values (N'Cửa sổ trời')


Delete from CANCUOCCONGDAN
DBCC CHECKIDENT ('CANCUOCCONGDAN', RESEED, 0) --Reset Identity
Insert into CANCUOCCONGDAN values ('0012000003134', N'Hà Nội', '12-03-2015', '', '')
Insert into CANCUOCCONGDAN values ('0012000003561', N'Hải Phòng', '05-09-2016', '', '')
Insert into CANCUOCCONGDAN values ('0012000004965', N'Nha Trang', '07-02-2017', '', '')
Insert into CANCUOCCONGDAN values ('0012000007951', N'Đà Nẵng', '03-01-2018', '', '')
Insert into CANCUOCCONGDAN values ('0012000001876', N'Bắc Giang', '09-12-2015', '', '')


Delete from HANGXE
DBCC CHECKIDENT ('HANGXE', RESEED, 0) --Reset Identity
Insert into HANGXE values('TOYOTA')
Insert into HANGXE values('LEXUS')
Insert into HANGXE values('VINFAST')
Insert into HANGXE values('HONDA')
Insert into HANGXE values('HUYNDAI')


Delete from MAUXE
DBCC CHECKIDENT ('MAUXE', RESEED, 0) --Reset Identity
Insert into MAUXE values('CAMRY', '1')
Insert into MAUXE values('SC430', '2')
Insert into MAUXE values('LUX A 2.0', '3')
Insert into MAUXE values('CRV', '4')
Insert into MAUXE values('GETZ', '5')
Insert into MAUXE values('VIOS', '1')


Delete from XE
DBCC CHECKIDENT ('XE', RESEED, 0) --Reset Identity
Insert into XE values ('MALA851CBHM557809', N'4 chỗ', 1, '', 7000, '30A-165325', N'Xăng',  3, N'Dẫn động cầu trước', N'Số sàn', '', '', N'Xe sạch đẹp', N'Đang hoạt động', '0')
Insert into XE values ('MBGB695VMGH731652', N'4 chỗ', 2, '', 8000, '29A-753658', N'Dầu', 4, N'Dẫn động cầu sau', N'Số tự động', '', '', N'Xe sáng bóng', N'Đang hoạt động', '0')
Insert into XE values ('GHTB164MTHF367419', N'4 chỗ', 3, '', 9000, '30A-963154', N'Dầu',  3, N'Dẫn động cầu trước', N'Số sàn', '', '', N'Xe siêu đẹp', N'Đang hoạt động', '0')
Insert into XE values ('ETHC653RTYV197645', N'4 chỗ', 4, '', 10000, '30A-746315', N'Xăng',  5, N'Dẫn động 4 bánh toàn thời gian', N'Số sàn', '', '', N'Xe xinh', N'Đang hoạt động', '0')
Insert into XE values ('WRBC761LFKC762516', N'4 chỗ', 5, '', 7000, '30A-165398', N'Xăng',  3, N'Dẫn động 4 bánh bán thời gian', N'Số sàn', '', '', N'Xe sạch đẹp', N'Đang hoạt động', '0')

Delete from TINHNANGXE
Insert into TINHNANGXE values (1,2)
Insert into TINHNANGXE values (1,3)
Insert into TINHNANGXE values (1,4)
Insert into TINHNANGXE values (1,1)
Insert into TINHNANGXE values (2,3)
Insert into TINHNANGXE values (4,5)
Insert into TINHNANGXE values (4,2)
Insert into TINHNANGXE values (5,5)
Insert into TINHNANGXE values (3,2)
Insert into TINHNANGXE values (2,2)

Delete from NGUOIDUNG where taikhoan ='test2'
Select * from HANGXE where id ='1'

Select * from NGUOIDUNG
Select * from XE
Select * from CANCUOCCONGDAN
Select * from MAUXE
Select * from HANGXE
Select * from TINHNANG
Select * from TINHNANGXE
Select * from HOADON
Select * from HOADONCHITIET


Delete from HOADON
Delete from HOADONCHITIET

---Drop all
drop table HOADONCHITIET
drop table HOADON 
drop table HOPDONG 
drop table TINHNANGXE 
drop table XE 
drop table MAUXE 
drop table HANGXE 
drop table TINHNANG 
drop table NGUOIDUNG 
drop table CANCUOCCONGDAN 

