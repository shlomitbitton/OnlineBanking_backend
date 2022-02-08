INSERT INTO user (USER_KEY, FIRST_NAME, LAST_NAME, PASSWORD, EMAIL, PHONE, PIN, USERNAME) VALUES (1, 'David', 'Zain', 'password','david@gmail.com', 5308442323, 4444,'username'),
  (2,'Shiela', 'Zik', 'password','shiela@gmail.com',5308442323,5555,'username'),
  (3,'Dana', 'Ger', 'password','dana@gmail.com',5308442323,6666,'username'),
  (4, 'testuser', 'last','password', 'test@test.com'  , 4564564564, 6789, 'username'),
  (5, 'David', 'Cohen', 'password','shlomit@test.com',  111111111, 3333, 'username');
insert into transaction_register ( transaction_register_key,from_account, to_account , transaction_type,timestamp, amount ) values (2, 2,1,1, '2022-01-01',200);
insert into account (account_key, account_type, balance, user_key) values(3,0, 50000,4);
insert into account (account_key, account_type, balance, user_key) values(1,2, 55000,4);
insert into account (account_key, account_type, balance, user_key) values(2,0, 50000,4);
insert into account (account_key, account_type, balance, user_key) values(2,0, 50000,2);
insert into account (account_key, account_type, balance, user_key) values(2,0, 50000,2);
 --insert into  user_accounts   ( user_user_key ,  accounts_account_key ) values(1, 1);