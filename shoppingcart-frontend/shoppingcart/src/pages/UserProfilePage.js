import React, { useEffect, useState } from 'react';
import { getUserInfo, updateUserInfo } from '../utils/api';

const UserProfilePage = () => {
  const [userInfo, setUserInfo] = useState({});

  useEffect(() => {
    getUserInfo()
      .then((response) => {
        setUserInfo(response.data);
      })
      .catch((error) => {
        console.error('Failed to fetch user info', error);
      });
  }, []);

  // 在此处添加 updateUserInfo 的函数实现

  return (
    <div>
      <h2>{userInfo.username}</h2>
      <p>{userInfo.address}</p>
      {/* 用户信息更新的输入和按钮在此处实现 */}
    </div>
  );
};

export default UserProfilePage;
