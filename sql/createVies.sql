CREATE VIEW v_generalopenparking AS SELECT * FROM `parkingspots` WHERE `lotnumber` IN  (
	SELECT `lotnumber` FROM `parkinglots` WHERE `lotnumber` NOT IN (
		SELECT `lotnumber` FROM `parkinglotsnear`
	)
) AND `snumber` IS NULL;

