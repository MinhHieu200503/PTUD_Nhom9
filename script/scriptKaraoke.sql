USE [master]
GO
/****** Object:  Database [KaraokeEcho]    Script Date: 10/25/2023 9:25:49 AM ******/
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
/****** Object:  Table [dbo].[Ca]    Script Date: 10/25/2023 9:25:49 AM ******/
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
/****** Object:  Table [dbo].[ChiTietDichVuHoaDon]    Script Date: 10/25/2023 9:25:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietDichVuHoaDon](
	[soLuong] [int] NULL,
	[maDV] [nchar](10) NOT NULL,
	[maHD] [nchar](10) NOT NULL,
	[maP] [nchar](10) NOT NULL,
 CONSTRAINT [PK_ChiTietDichVuHoaDon] PRIMARY KEY CLUSTERED 
(
	[maDV] ASC,
	[maHD] ASC,
	[maP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChiTietPhongHoaDon]    Script Date: 10/25/2023 9:25:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ChiTietPhongHoaDon](
	[thoiGianNhanPhong] [datetime] NULL,
	[thoiGianTraPhong] [datetime] NULL,
	[ghiChu] [nvarchar](50) NULL,
	[maHD] [nchar](10) NOT NULL,
	[maP] [nchar](10) NOT NULL,
 CONSTRAINT [PK_ChiTietPhongHoaDon] PRIMARY KEY CLUSTERED 
(
	[maHD] ASC,
	[maP] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ChucVu]    Script Date: 10/25/2023 9:25:49 AM ******/
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
/****** Object:  Table [dbo].[DichVu]    Script Date: 10/25/2023 9:25:49 AM ******/
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
/****** Object:  Table [dbo].[HoaDon]    Script Date: 10/25/2023 9:25:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HoaDon](
	[maHoaDon] [nchar](10) NOT NULL,
	[ngayLapHoaDon] [datetime] NULL,
	[trangThai] [int] NULL,
	[maKH] [nchar](10) NULL,
	[maUD] [nchar](10) NULL,
	[maNV] [nchar](10) NULL,
 CONSTRAINT [PK_HoaDon] PRIMARY KEY CLUSTERED 
(
	[maHoaDon] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KhachHang]    Script Date: 10/25/2023 9:25:49 AM ******/
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
/****** Object:  Table [dbo].[LoaiPhong]    Script Date: 10/25/2023 9:25:49 AM ******/
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
/****** Object:  Table [dbo].[NhanVien]    Script Date: 10/25/2023 9:25:49 AM ******/
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
	[maCV] [nchar](10) NULL,
	[maCa] [nchar](10) NULL,
 CONSTRAINT [PK_NhanVien] PRIMARY KEY CLUSTERED 
(
	[maNhanVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[PhieuDatPhong]    Script Date: 10/25/2023 9:25:49 AM ******/
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
	[maNV] [nchar](10) NULL,
	[maKH] [nchar](10) NULL,
	[maP] [nchar](10) NULL,
 CONSTRAINT [PK_PhieuDatPhong] PRIMARY KEY CLUSTERED 
(
	[maPhieuDatPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Phong]    Script Date: 10/25/2023 9:25:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Phong](
	[maPhong] [nchar](10) NOT NULL,
	[tenPhong] [nvarchar](50) NOT NULL,
	[trangThai] [int] NULL,
	[maLP] [nchar](10) NULL,
	[sucChuaToiDa] [int] NULL,
	[giaPhongTheoGio] [float] NULL,
 CONSTRAINT [PK_Phong] PRIMARY KEY CLUSTERED 
(
	[maPhong] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TaiKhoan]    Script Date: 10/25/2023 9:25:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TaiKhoan](
	[tenTaiKhoan] [nchar](10) NOT NULL,
	[matKhau] [nchar](30) NOT NULL,
	[vaiTro] [bit] NULL,
	[maNV] [nchar](10) NULL,
 CONSTRAINT [PK_TaiKhoan] PRIMARY KEY CLUSTERED 
(
	[tenTaiKhoan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UuDai]    Script Date: 10/25/2023 9:25:49 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UuDai](
	[maUuDai] [nchar](10) NOT NULL,
	[tenUuDai] [nvarchar](50) NOT NULL,
	[giamGia] [float] NULL,
	[ngayBatDauApDung] [datetime] NULL,
	[ngayKetThucApDung] [datetime] NULL,
 CONSTRAINT [PK_UuDai] PRIMARY KEY CLUSTERED 
(
	[maUuDai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_madichvu] FOREIGN KEY([maDV])
REFERENCES [dbo].[DichVu] ([maDichVu])
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon] CHECK CONSTRAINT [fk_madichvu]
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_mahoadon] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon] CHECK CONSTRAINT [fk_mahoadon]
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_map] FOREIGN KEY([maP])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[ChiTietDichVuHoaDon] CHECK CONSTRAINT [fk_map]
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_mahd] FOREIGN KEY([maHD])
REFERENCES [dbo].[HoaDon] ([maHoaDon])
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon] CHECK CONSTRAINT [fk_mahd]
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon]  WITH CHECK ADD  CONSTRAINT [fk_maphong] FOREIGN KEY([maP])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[ChiTietPhongHoaDon] CHECK CONSTRAINT [fk_maphong]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([soDienThoai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_KhachHang]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_NhanVien]
GO
ALTER TABLE [dbo].[HoaDon]  WITH CHECK ADD  CONSTRAINT [FK_HoaDon_UuDai] FOREIGN KEY([maUD])
REFERENCES [dbo].[UuDai] ([maUuDai])
GO
ALTER TABLE [dbo].[HoaDon] CHECK CONSTRAINT [FK_HoaDon_UuDai]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_Ca] FOREIGN KEY([maCa])
REFERENCES [dbo].[Ca] ([maCa])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_Ca]
GO
ALTER TABLE [dbo].[NhanVien]  WITH CHECK ADD  CONSTRAINT [FK_NhanVien_ChucVu] FOREIGN KEY([maCV])
REFERENCES [dbo].[ChucVu] ([maChucVu])
GO
ALTER TABLE [dbo].[NhanVien] CHECK CONSTRAINT [FK_NhanVien_ChucVu]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_KhachHang] FOREIGN KEY([maKH])
REFERENCES [dbo].[KhachHang] ([soDienThoai])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_KhachHang]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_NhanVien]
GO
ALTER TABLE [dbo].[PhieuDatPhong]  WITH CHECK ADD  CONSTRAINT [FK_PhieuDatPhong_Phong] FOREIGN KEY([maP])
REFERENCES [dbo].[Phong] ([maPhong])
GO
ALTER TABLE [dbo].[PhieuDatPhong] CHECK CONSTRAINT [FK_PhieuDatPhong_Phong]
GO
ALTER TABLE [dbo].[Phong]  WITH CHECK ADD  CONSTRAINT [FK_Phong_LoaiPhong] FOREIGN KEY([maLP])
REFERENCES [dbo].[LoaiPhong] ([maLoaiPhong])
GO
ALTER TABLE [dbo].[Phong] CHECK CONSTRAINT [FK_Phong_LoaiPhong]
GO
ALTER TABLE [dbo].[TaiKhoan]  WITH CHECK ADD  CONSTRAINT [FK_TaiKhoan_NhanVien] FOREIGN KEY([maNV])
REFERENCES [dbo].[NhanVien] ([maNhanVien])
GO
ALTER TABLE [dbo].[TaiKhoan] CHECK CONSTRAINT [FK_TaiKhoan_NhanVien]
GO
USE [master]
GO
ALTER DATABASE [KaraokeEcho] SET  READ_WRITE 
GO
