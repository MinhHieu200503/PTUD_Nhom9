USE [master]
GO
/****** Object:  Database [KaraokeEcho]    Script Date: 11/19/2023 9:09:41 PM ******/
CREATE DATABASE [KaraokeEcho]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'KaraokeEcho', FILENAME = N'D:\17d\Ptud\doan\karaokeEcho\data\KaraokeEcho.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'KaraokeEcho_log', FILENAME = N'D:\17d\Ptud\doan\karaokeEcho\data\KaraokeEcho_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [KaraokeEcho] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [KaraokeEcho].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [KaraokeEcho] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [KaraokeEcho] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [KaraokeEcho] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [KaraokeEcho] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [KaraokeEcho] SET ARITHABORT OFF 
GO
ALTER DATABASE [KaraokeEcho] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [KaraokeEcho] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [KaraokeEcho] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [KaraokeEcho] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [KaraokeEcho] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [KaraokeEcho] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [KaraokeEcho] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [KaraokeEcho] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [KaraokeEcho] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [KaraokeEcho] SET  DISABLE_BROKER 
GO
ALTER DATABASE [KaraokeEcho] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [KaraokeEcho] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [KaraokeEcho] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [KaraokeEcho] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [KaraokeEcho] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [KaraokeEcho] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [KaraokeEcho] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [KaraokeEcho] SET RECOVERY FULL 
GO
ALTER DATABASE [KaraokeEcho] SET  MULTI_USER 
GO
ALTER DATABASE [KaraokeEcho] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [KaraokeEcho] SET DB_CHAINING OFF 
GO
ALTER DATABASE [KaraokeEcho] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [KaraokeEcho] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [KaraokeEcho] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [KaraokeEcho] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'KaraokeEcho', N'ON'
GO
ALTER DATABASE [KaraokeEcho] SET QUERY_STORE = OFF
GO
USE [KaraokeEcho]
GO
/****** Object:  Table [dbo].[Ca]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ca](
	[maCa] [nchar](5) NOT NULL,
	[tenCa] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_CA] PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDichVuHoaDon]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVuHoaDon](
	[soLuong] [int] NULL,
	[maDichVu] [nchar](5) NOT NULL,
	[maHoaDon] [nchar](13) NOT NULL,
	[maPhong] [nchar](5) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhongHoaDon]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhongHoaDon](
	[thoiGianNhanPhong] [datetime] NULL,
	[thoiGianTraPhong] [datetime] NULL,
	[ghiChu] [nvarchar](50) NULL,
	[maHoaDon] [nchar](13) NOT NULL,
	[maPhong] [nchar](5) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nchar](5) NOT NULL,
	[tenDichVu] [nvarchar](50) NOT NULL,
	[gia] [float] NULL,
	[soLuong] [int] NULL,
	[trangThai] [int] NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_DichVu] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](13) NOT NULL,
	[ngayLapHoaDon] [datetime] NULL,
	[trangThai] [int] NULL,
	[ghiChu] [nvarchar](50) NULL,
	[maKhachHang] [nchar](10) NULL,
	[maUuDai] [nchar](5) NULL,
	[maNhanVien] [nchar](5) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KhachHang](
	[soDienThoai] [nchar](10) NOT NULL,
	[tenKhachHang] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_KhachHang] PRIMARY KEY CLUSTERED 
(
	[soDienThoai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [nchar](5) NOT NULL,
	[loaiPhong] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](5) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[CMND] [nchar](12) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDienThoai] [nchar](10) NOT NULL,
	[trangThai] [bit] NULL,
	[gmail] [nchar](20) NULL,
	[maCa] [nchar](5) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[maPhieuDatPhong] [nchar](6) NOT NULL,
	[thoiGianTaoPhieu] [datetime] NULL,
	[thoiGianNhanPhong] [datetime] NULL,
	[trangThai] [int] NULL,
	[datCoc] [float] NULL,
	[maNhanVien] [nchar](5) NULL,
	[maKhachHang] [nchar](10) NULL,
	[maPhong] [nchar](5) NULL,
	[maHoaDon] [nchar](13) NULL,
 CONSTRAINT [PK_PhieuDatPhong] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nchar](5) NOT NULL,
	[tenPhong] [nvarchar](50) NOT NULL,
	[trangThai] [int] NULL,
	[maLoaiPhong] [nchar](5) NULL,
	[sucChuaToiDa] [int] NULL,
	[giaPhongTheoGio] [float] NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nchar](10) NOT NULL,
	[matKhau] [nchar](30) NOT NULL,
	[vaiTro] [bit] NULL,
	[maNhanVien] [nchar](5) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UuDai]    Script Date: 11/19/2023 9:09:41 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UuDai](
	[maUuDai] [nchar](5) NOT NULL,
	[tenUuDai] [nvarchar](50) NOT NULL,
	[giamGia] [float] NULL,
	[ngayBatDauApDung] [date] NULL,
	[ngayKetThucApDung] [date] NULL,
 CONSTRAINT [PK_UuDai] PRIMARY KEY CLUSTERED 
(
	[maUuDai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Ca] ([maCa], [tenCa], [moTa]) VALUES (N'CA001', N'Sáng', N'8h - 13h')
INSERT [dbo].[Ca] ([maCa], [tenCa], [moTa]) VALUES (N'CA002', N'Chiều', N'13h - 18h')
INSERT [dbo].[Ca] ([maCa], [tenCa], [moTa]) VALUES (N'CA003', N'Tối', N'18h - 20h')
GO
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [gia], [soLuong], [trangThai], [moTa]) VALUES (N'DV001', N'coca', 800, 300, 1, NULL)
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [gia], [soLuong], [trangThai], [moTa]) VALUES (N'DV002', N'Pepsi', 800, 400, 1, N'')
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [gia], [soLuong], [trangThai], [moTa]) VALUES (N'DV003', N'Pizza', 345.9, 20, 0, N'')
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [trangThai], [ghiChu], [maKhachHang], [maUuDai], [maNhanVien]) VALUES (N'HD19112023001', CAST(N'2023-11-19T21:01:00.000' AS DateTime), 0, NULL, N'0398242146', N'UD001', N'NV001')
GO
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0398242144', N'Nguyễn Hưng Tùng')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0398242146', N'Đặng Nam Phong')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0398242147', N'Mn Mn')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0901234567', N'Ngô Anh Thư')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0901234568', N'Ngọc Bích Thùy')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0901234569', N'Ngọc Châu Linh')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0912345678', N'Hoàng Minh Tuấn')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0912345679', N'Hoàng Huy Hùng')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0912345680', N'Hoàng Linh Hà')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0923456789', N'Lê Kim Ánh')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0923456790', N'Nguyễn Thị Mai')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0923456791', N'Nguyễn Văn Toàn')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0933456789', N'Trần Ngọc Bích')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0933456790', N'Cao Sơn Bá')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0933456791', N'Nguyễn Thị Trúc')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0943456789', N'Phan Bích Chi')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0943456790', N'Nguyễn Văn Nam')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0943456791', N'Lê Văn Hoàng')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0953456789', N'Đặng Hồng Diễm')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0953456790', N'Vũ Văn Huy')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0953456791', N'Hồ Lan Chi')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0963456789', N'Huỳnh Thị Lan')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0963456790', N'Nguyễn Đình Long')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0963456791', N'Mai Thanh Huyền')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0973456789', N'Nguyễn Thị Ngọc')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0973456790', N'Nguyễn Thị Tuyết')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0973456791', N'Đỗ Uyên Thư')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0983456789', N'Hồ Thị Oanh')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0983456790', N'Võ Đình Tùng')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0983456791', N'Đặng Quỳnh Chi')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0993456789', N'Đỗ Mai Phương')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0993456790', N'Trần Thảo My')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0993456791', N'Phan Bảo Hồng')
GO
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [loaiPhong], [moTa]) VALUES (N'LP001', N'Vip', NULL)
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [loaiPhong], [moTa]) VALUES (N'LP002', N'Thường', N'')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maCa]) VALUES (N'NV001', N'Táo Táo', CAST(N'2000-12-12' AS Date), 0, N'090909090922', N'Việt Nam', N'0980977789', 1, N'mot2@gmail.com      ', N'CA003')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maCa]) VALUES (N'NV002', N'Chuối Chuối', CAST(N'2001-10-28' AS Date), 0, N'072222090992', N'Gò vấp', N'0123982551', 0, N'2aaa@gmail.com      ', N'CA001')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maCa]) VALUES (N'NV003', N'Dâu Tây', CAST(N'2000-05-12' AS Date), 0, N'012345678900', N'Gò vấp', N'0987654321', 0, N'dautay@gmail.com    ', N'CA001')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maCa]) VALUES (N'NV004', N'Test Thử', CAST(N'2000-06-09' AS Date), 1, N'012345678912', N'Việt Nam', N'0947824242', 1, N'mnb@gmail.com       ', N'CA002')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maCa]) VALUES (N'NV005', N'Cam Cao', CAST(N'1995-11-09' AS Date), 1, N'091234567899', N'Biển đông', N'0782482432', 1, N'Lnba@gmail.com      ', N'CA002')
GO
INSERT [dbo].[PhieuDatPhong] ([maPhieuDatPhong], [thoiGianTaoPhieu], [thoiGianNhanPhong], [trangThai], [datCoc], [maNhanVien], [maKhachHang], [maPhong], [maHoaDon]) VALUES (N'DPP003', CAST(N'2023-11-19T21:01:00.000' AS DateTime), CAST(N'2023-11-20T08:00:00.000' AS DateTime), 0, 900, N'NV001', N'0398242146', N'MP001', N'HD19112023001')
GO
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP001', N'Phòng 01', 0, N'LP001', 5, 900)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP002', N'Phòng 02', 0, N'LP002', 15, 8000)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP003', N'Phòng 03', 0, N'LP001', 15, 300000)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP004', N'Phòng 04', 0, N'LP002', 5, 250)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP005', N'Phòng 05', 0, N'LP001', 10, 450)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP006', N'Phòng 06', 0, N'LP001', 15, 750)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP007', N'Phòng 07', 0, N'LP002', 10, 500)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP008', N'Phòng 08', 0, N'LP001', 5, 300)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP009', N'Phòng 09', 0, N'LP002', 15, 750)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP010', N'Phòng 10', 0, N'LP001', 5, 450.599)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP011', N'Phòng 11', 0, N'LP001', 5, 300)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP012', N'Phòng 12', 0, N'LP002', 10, 500)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP013', N'Phòng 13', 0, N'LP001', 15, 750)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP014', N'Phòng 14', 0, N'LP002', 5, 250)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP015', N'Phòng 15', 0, N'LP001', 10, 450)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP016', N'Phòng 16', 0, N'LP001', 15, 750)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP017', N'Phòng 17', 0, N'LP002', 10, 500)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP018', N'Phòng 18', 0, N'LP001', 5, 300)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP019', N'Phòng 19', 0, N'LP002', 15, 750)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP020', N'Phòng 20', 0, N'LP001', 10, 450)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP021', N'Phòng 21', 0, N'LP001', 5, 300)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP022', N'Phòng 22', 0, N'LP002', 10, 500)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP023', N'Phòng 23', 0, N'LP001', 15, 750)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP024', N'Phòng 24', 0, N'LP002', 5, 250)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP025', N'Phòng 05', 0, N'LP002', 5, 500000)
GO
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0123982551', N'777                           ', 0, N'NV002')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0782482432', N'Lkjh89@mn                     ', 0, N'NV005')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0947824242', N'6K#mnb                        ', 0, N'NV004')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0980977789', N'123                           ', 1, N'NV001')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0987654321', N'Dautay@12                     ', 0, N'NV003')
GO
INSERT [dbo].[UuDai] ([maUuDai], [tenUuDai], [giamGia], [ngayBatDauApDung], [ngayKetThucApDung]) VALUES (N'UD001', N'Test', 0, CAST(N'2023-12-04' AS Date), CAST(N'2024-12-13' AS Date))
INSERT [dbo].[UuDai] ([maUuDai], [tenUuDai], [giamGia], [ngayBatDauApDung], [ngayKetThucApDung]) VALUES (N'UD002', N'Hè', 0.3, CAST(N'2023-11-15' AS Date), CAST(N'2023-12-19' AS Date))
INSERT [dbo].[UuDai] ([maUuDai], [tenUuDai], [giamGia], [ngayBatDauApDung], [ngayKetThucApDung]) VALUES (N'UD003', N'Tết', 0.05, CAST(N'2023-11-15' AS Date), CAST(N'2023-11-17' AS Date))
INSERT [dbo].[UuDai] ([maUuDai], [tenUuDai], [giamGia], [ngayBatDauApDung], [ngayKetThucApDung]) VALUES (N'UD004', N'Đông', 0.02, CAST(N'2023-11-16' AS Date), CAST(N'2023-11-23' AS Date))
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_madichvu] FOREIGN KEY([maDichVu])
REFERENCES [dbo].[DichVu] ([maDichVu])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon] CHECK CONSTRAINT [fk_madichvu]
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_mahoadon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon] CHECK CONSTRAINT [fk_mahoadon]
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_map] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon] CHECK CONSTRAINT [fk_map]
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_mahd] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon] CHECK CONSTRAINT [fk_mahd]
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_maphong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon] CHECK CONSTRAINT [fk_maphong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([soDienThoai])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien1] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien1]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_UuDai] FOREIGN KEY([maUuDai])
REFERENCES [dbo].[UuDai] ([maUuDai])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_UuDai]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Ca] FOREIGN KEY([maCa])
REFERENCES [dbo].[Ca] ([maCa])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Ca]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_HoaDon] FOREIGN KEY([maHoaDon])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_HoaDon]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_KhachHang] FOREIGN KEY([maKhachHang])
REFERENCES [dbo].[KhachHang] ([soDienThoai])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_NhanVien]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_Phong] FOREIGN KEY([maPhong])
REFERENCES [dbo].[Phong] ([maPhong])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([maLoaiPhong])
REFERENCES [dbo].[LoaiPhong] ([maLoaiPhong])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNhanVien])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [KaraokeEcho] SET  READ_WRITE 
GO
