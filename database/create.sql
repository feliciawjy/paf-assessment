-- Task 1
-- Write SQL statements in this file to create the brewery database and 
-- populate the database with the given SQL files

CREATE SCHEMA brewery;
USE brewery;

-- SOURCE database/beers.sql;
-- SOURCE database/breweries.sql;
-- SOURCE database/categories.sql;
-- SOURCE database/geocodes.sql;
-- SOURCE database/styles.sql;

CREATE USER 'brewery'@'localhost' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON brewery.* TO 'brewery'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

DROP TABLE IF EXISTS `beers`;
CREATE TABLE `beers` (
  `id` int(21) NOT NULL auto_increment,
  `brewery_id` int(21) NOT NULL default '0',
  `name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `cat_id` int(11) NOT NULL default '0',
  `style_id` int(11) NOT NULL default '0',
  `abv` float NOT NULL default '0',
  `ibu` float NOT NULL default '0',
  `srm` float NOT NULL default '0',
  `upc` int(40) NOT NULL default '0',
  `filepath` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `descript` text character set utf8 collate utf8_unicode_ci NOT NULL,
  `add_user` int(11) NOT NULL default '0',
  `last_mod` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`),
	foreign key(`brewery_id`) references breweries(`id`),
	foreign key(`cat_id`) references categories(`id`),
	foreign key(`style_id`) references styles(`id`)
);

DROP TABLE IF EXISTS `breweries`;
CREATE TABLE `breweries` (
  `id` int(21) NOT NULL auto_increment,
  `name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `address1` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `address2` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `city` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `state` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `code` varchar(25) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `country` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `phone` varchar(50) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `website` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `filepath` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `descript` text character set utf8 collate utf8_unicode_ci NOT NULL,
  `add_user` int(11) NOT NULL default '0',
  `last_mod` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1424 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `categories`;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL auto_increment,
  `cat_name` varchar(255) NOT NULL default '',
  `last_mod` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `breweries_geocode`;
CREATE TABLE `breweries_geocode` (
  `id` int(11) NOT NULL auto_increment,
  `brewery_id` int(11) NOT NULL default '0',
  `latitude` float NOT NULL default '0',
  `longitude` float NOT NULL default '0',
  `accuracy` varchar(255) NOT NULL default '',
  PRIMARY KEY  (`id`),
	foreign key(`brewery_id`) references breweries(`id`)
);

DROP TABLE IF EXISTS `styles`;
CREATE TABLE `styles` (
  `id` int(11) NOT NULL auto_increment,
  `cat_id` int(11) NOT NULL default '0',
  `style_name` varchar(255) character set utf8 collate utf8_unicode_ci NOT NULL default '',
  `last_mod` datetime NOT NULL default '0000-00-00 00:00:00',
  PRIMARY KEY  (`id`),
	foreign key(`cat_id`) references categories(`id`)
);



