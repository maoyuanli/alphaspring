INSERT INTO trade_account (account_no)
VALUES ('TA001');
INSERT INTO trade_account (account_no)
VALUES ('TA002');
INSERT INTO trade_account (account_no)
VALUES ('TA003');

INSERT INTO trade_order (created_date, order_price, order_type, order_volumn, ticker)
VALUES (current_timestamp, '15.05', 'Limited Buy', '3500', 'ABN AMRO BANK N.V. (ABN)');
INSERT INTO trade_order (created_date, order_price, order_type, order_volumn, ticker)
VALUES (current_timestamp, null, 'Market Sell', '20000', 'ROYAL DUTCH SHELLA (RDSA)');
INSERT INTO trade_order (created_date, order_price, order_type, order_volumn, ticker)
VALUES (current_timestamp, '15.10', 'Limited Buy', '7000', 'ABN AMRO BANK N.V. (ABN)');

INSERT INTO feedback(comment, created_date, email, name, phone)
VALUES ('hi, good job!', current_timestamp, 'shneider.gunn@gmail.com', 'Shneider, Gunn', '123-098-9383');
INSERT INTO feedback(comment, created_date, email, name, phone)
VALUES ('Can you contact me? I have a question.', current_timestamp, 'Jenny.H@bell.ca', 'Jenny', '903-930-1355');
INSERT INTO feedback(comment, created_date, email, name, phone)
VALUES ('Why there is no APPL info?', current_timestamp, 'wendimckensy@skynet.co.uk', 'Wendi Mckensy',
        '004-203-112-9080');