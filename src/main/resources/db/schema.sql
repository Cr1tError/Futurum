DROP TABLE IF EXISTS campaign;
CREATE TABLE campaign (
    id INTEGER NOT NULL AUTO_INCREMENT,
    name VARCHAR NOT NULL,
    keywords VARCHAR NOT NULL,
    bid_amount INTEGER NOT NULL,
    campaign_fund INTEGER NOT NULL,
    status BOOLEAN NOT NULL,
    city VARCHAR NOT NULL,
    kilometers INTEGER  NOT NULL,
    PRIMARY KEY (id)
);