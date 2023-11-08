USE [master]
GO
/****** Object:  Database [KaraokeEcho]    Script Date: 11/8/2023 9:08:14 AM ******/
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
/****** Object:  Table [dbo].[Ca]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ca](
	[maCa] [nchar](10) NOT NULL,
	[tenCa] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_CA] PRIMARY KEY CLUSTERED 
(
	[maCa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietDichVuHoaDon]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVuHoaDon](
	[soLuong] [int] NULL,
	[maDichVu] [nchar](10) NOT NULL,
	[maHoaDon] [nchar](10) NOT NULL,
	[maPhong] [nchar](10) NOT NULL,
 CONSTRAINT [PK_ChiTietDichVuHoaDon] PRIMARY KEY CLUSTERED 
(
	[maDichVu] ASC,
	[maHoaDon] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhongHoaDon]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhongHoaDon](
	[thoiGianNhanPhong] [datetime] NULL,
	[thoiGianTraPhong] [datetime] NULL,
	[ghiChu] [nvarchar](50) NULL,
	[maHoaDon] [nchar](10) NOT NULL,
	[maPhong] [nchar](10) NOT NULL,
 CONSTRAINT [PK_ChiTietPhongHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC,
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChucVu](
	[maChucVu] [nchar](10) NOT NULL,
	[tenChucVu] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_ChucVu] PRIMARY KEY CLUSTERED 
(
	[maChucVu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DichVu]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DichVu](
	[maDichVu] [nchar](10) NOT NULL,
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](10) NOT NULL,
	[ngayLapHoaDon] [datetime] NULL,
	[trangThai] [int] NULL,
	[maKhachHang] [nchar](10) NULL,
	[maUuDai] [nchar](10) NULL,
	[maNhanVien] [nchar](10) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 11/8/2023 9:08:15 AM ******/
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
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LoaiPhong](
	[maLoaiPhong] [nchar](10) NOT NULL,
	[loaiPhong] [nvarchar](50) NOT NULL,
	[moTa] [nvarchar](50) NULL,
 CONSTRAINT [PK_LoaiPhong] PRIMARY KEY CLUSTERED 
(
	[maLoaiPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[NhanVien]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[NhanVien](
	[maNhanVien] [nchar](10) NOT NULL,
	[tenNhanVien] [nvarchar](50) NOT NULL,
	[ngaySinh] [date] NULL,
	[gioiTinh] [bit] NULL,
	[CMND] [nchar](12) NULL,
	[diaChi] [nvarchar](50) NULL,
	[soDienThoai] [nchar](10) NOT NULL,
	[trangThai] [bit] NULL,
	[gmail] [nchar](20) NULL,
	[maChucVu] [nchar](10) NULL,
	[maCa] [nchar](10) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PhieuDatPhong](
	[maPhieuDatPhong] [nchar](10) NOT NULL,
	[thoiGianTaoPhieu] [datetime] NULL,
	[thoiGianNhanPhong] [datetime] NULL,
	[trangThai] [int] NULL,
	[datCoc] [float] NULL,
	[maNhanVien] [nchar](10) NULL,
	[maKhachHang] [nchar](10) NULL,
	[maPhong] [nchar](10) NULL,
	[maHoaDon] [nchar](10) NULL,
 CONSTRAINT [PK_PhieuDatPhong] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nchar](10) NOT NULL,
	[tenPhong] [nvarchar](50) NOT NULL,
	[trangThai] [int] NULL,
	[maLoaiPhong] [nchar](10) NULL,
	[sucChuaToiDa] [int] NULL,
	[giaPhongTheoGio] [float] NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nchar](10) NOT NULL,
	[matKhau] [nchar](30) NOT NULL,
	[vaiTro] [bit] NULL,
	[maNhanVien] [nchar](10) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UuDai]    Script Date: 11/8/2023 9:08:15 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UuDai](
	[maUuDai] [nchar](10) NOT NULL,
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
INSERT [dbo].[Ca] ([maCa], [tenCa], [moTa]) VALUES (N'CA001     ', N'Sáng', NULL)
INSERT [dbo].[Ca] ([maCa], [tenCa], [moTa]) VALUES (N'CA002     ', N'Chiều', NULL)
INSERT [dbo].[Ca] ([maCa], [tenCa], [moTa]) VALUES (N'CA003     ', N'Tối', N'')
GO
INSERT [dbo].[ChiTietDichVuHoaDon] ([soLuong], [maDichVu], [maHoaDon], [maPhong]) VALUES (20, N'DV001     ', N'HD001     ', N'MP002     ')
INSERT [dbo].[ChiTietDichVuHoaDon] ([soLuong], [maDichVu], [maHoaDon], [maPhong]) VALUES (30, N'DV002     ', N'HD001     ', N'MP002     ')
GO
INSERT [dbo].[ChiTietPhongHoaDon] ([thoiGianNhanPhong], [thoiGianTraPhong], [ghiChu], [maHoaDon], [maPhong]) VALUES (CAST(N'2023-06-03T00:00:00.000' AS DateTime), CAST(N'2023-06-03T09:00:00.000' AS DateTime), N'nothing', N'HD001     ', N'MP001     ')
INSERT [dbo].[ChiTietPhongHoaDon] ([thoiGianNhanPhong], [thoiGianTraPhong], [ghiChu], [maHoaDon], [maPhong]) VALUES (CAST(N'2023-07-01T00:00:00.000' AS DateTime), CAST(N'2023-07-01T08:00:00.000' AS DateTime), NULL, N'HD002     ', N'MP002     ')
GO
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [moTa]) VALUES (N'CV001     ', N'Quản lí', N'Toàn quyền')
INSERT [dbo].[ChucVu] ([maChucVu], [tenChucVu], [moTa]) VALUES (N'CV002     ', N'Nhân Viên', N'')
GO
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [gia], [soLuong], [trangThai], [moTa]) VALUES (N'DV001     ', N'coca', 800, 300, 1, NULL)
INSERT [dbo].[DichVu] ([maDichVu], [tenDichVu], [gia], [soLuong], [trangThai], [moTa]) VALUES (N'DV002     ', N'pepsi', 800, 400, 0, NULL)
GO
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [trangThai], [maKhachHang], [maUuDai], [maNhanVien]) VALUES (N'HD001     ', CAST(N'2023-05-03T00:00:00.000' AS DateTime), 1, N'0398242145', N'UD001     ', N'NV001     ')
INSERT [dbo].[HoaDon] ([maHoaDon], [ngayLapHoaDon], [trangThai], [maKhachHang], [maUuDai], [maNhanVien]) VALUES (N'HD002     ', CAST(N'2023-06-01T00:00:00.000' AS DateTime), 0, N'0901234568', N'UD002     ', N'NV002     ')
GO
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0123456789', N'Ln Ln')
INSERT [dbo].[KhachHang] ([soDienThoai], [tenKhachHang]) VALUES (N'0398242145', N'Nguyễn Hưng Tùng')
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
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [loaiPhong], [moTa]) VALUES (N'LP001     ', N'Vip', NULL)
INSERT [dbo].[LoaiPhong] ([maLoaiPhong], [loaiPhong], [moTa]) VALUES (N'LP002     ', N'Thường', N'nothing')
GO
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maChucVu], [maCa]) VALUES (N'NV001     ', N'táo', CAST(N'2000-12-12' AS Date), 0, N'0909090909  ', N'jkljlkjk', N'0980977789', 1, N'mot2                ', N'CV001     ', N'CA003     ')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maChucVu], [maCa]) VALUES (N'NV002     ', N'chuối', CAST(N'2023-10-28' AS Date), 0, N'072222      ', N'gò vấp', N'0123      ', 0, N'2@l.l               ', N'CV002     ', N'CA001     ')
INSERT [dbo].[NhanVien] ([maNhanVien], [tenNhanVien], [ngaySinh], [gioiTinh], [CMND], [diaChi], [soDienThoai], [trangThai], [gmail], [maChucVu], [maCa]) VALUES (N'NV003     ', N'Dâu Tây', CAST(N'2000-05-12' AS Date), 0, N'012345678900', N'Gò vấp', N'0987654321', 1, N'dautay@gmail.com    ', N'CV001     ', N'CA001     ')
GO
INSERT [dbo].[PhieuDatPhong] ([maPhieuDatPhong], [thoiGianTaoPhieu], [thoiGianNhanPhong], [trangThai], [datCoc], [maNhanVien], [maKhachHang], [maPhong], [maHoaDon]) VALUES (N'DPT001    ', CAST(N'2023-10-29T00:00:00.000' AS DateTime), CAST(N'2023-11-03T00:00:00.000' AS DateTime), 1, 900, N'NV002     ', N'0901234567', N'MP001     ', N'HD001     ')
INSERT [dbo].[PhieuDatPhong] ([maPhieuDatPhong], [thoiGianTaoPhieu], [thoiGianNhanPhong], [trangThai], [datCoc], [maNhanVien], [maKhachHang], [maPhong], [maHoaDon]) VALUES (N'DPT002    ', CAST(N'2023-10-15T00:00:00.000' AS DateTime), CAST(N'2023-10-30T00:00:00.000' AS DateTime), 0, 1000, N'NV001     ', N'0933456789', N'MP002     ', N'HD002     ')
GO
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP001     ', N'p90', 2, N'LP001     ', 5, 900)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP002     ', N'p98', 1, N'LP002     ', 15, 8000)
INSERT [dbo].[Phong] ([maPhong], [tenPhong], [trangThai], [maLoaiPhong], [sucChuaToiDa], [giaPhongTheoGio]) VALUES (N'MP003     ', N'Phòng 03', 0, N'LP001     ', 15, 300000)
GO
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0123      ', N'777                           ', 0, N'NV002     ')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0980977789', N'123                           ', 1, N'NV001     ')
INSERT [dbo].[TaiKhoan] ([tenTaiKhoan], [matKhau], [vaiTro], [maNhanVien]) VALUES (N'0987654321', N'Dautay@12                     ', 1, N'NV003     ')
GO
INSERT [dbo].[UuDai] ([maUuDai], [tenUuDai], [giamGia], [ngayBatDauApDung], [ngayKetThucApDung]) VALUES (N'UD001     ', N'yeah', 0.3, CAST(N'2023-12-12' AS Date), CAST(N'2024-01-30' AS Date))
INSERT [dbo].[UuDai] ([maUuDai], [tenUuDai], [giamGia], [ngayBatDauApDung], [ngayKetThucApDung]) VALUES (N'UD002     ', N'Ok', 0.3, CAST(N'2023-11-13' AS Date), CAST(N'2023-12-19' AS Date))
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
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([maChucVu])
REFERENCES [dbo].[ChucVu] ([maChucVu])
ON UPDATE CASCADE
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
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
