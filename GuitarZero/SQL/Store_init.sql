/* I used MariaDB to run this code, which I believe runs off MySQL.*/
Create database GZLStore;
ON PRIMARY (
	NAME = StoreDatabase,
	FILENAME = 'C:\Users\Zach\Documents\newGuitar\StoreDB.mdf'
), 
FILEGROUP StoreFS CONTAINS FILESTREAM(
	NAME = StoreFS,
	FILENAME = 'C:\Users\Zach\Documents\newGuitar\StoreFS')
LOG ON (
	NAME = StoreLog,
	FILENAME = 'C:\Users\Zach\Documents\newGuitar\StoreLOG.ldf');
GO

Use GZLStore;
Create Table Songs(
	SongID integer AUTO_INCREMENT, 
	Name Varchar(50),
	Artist Varchar(50),
	pngFile VARBINARY(MAX) FILESTREAM NULL,
	MidiFile VARBINARY(MAX) FILESTREAM NULL,
	PRIMARY KEY (SongID)
);
GO
