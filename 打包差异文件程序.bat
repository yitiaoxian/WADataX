@echo off
echo E盘项目路径下取更新文件
::echo 清理更新包存放目录
::rd /s /q E:\gitUpdate\test1

::echo 创建存放目录
::md E:\gitUpdate\test2


echo 进入git的resources目录
cd /d E:
CD E:\DataX\


set /p a=请输入开始版本号a:
set /p b=请输入结束版本号b:


echo 获取差异并打包
git diff %a% %b% --name-only | xargs zip DataUpdate.zip


rem echo git diff %a% %b% --name-only




::echo 解压到打包目录
::tar -zxvf gengxinbao.tar.gz -C D:/update/test2/


::echo 删除差异压缩包
::del gengxinbao.tar.gz


echo 搞定
echo 按任意键退出
pause>nul
exit