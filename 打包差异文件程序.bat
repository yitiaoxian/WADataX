@echo off
echo E����Ŀ·����ȡ�����ļ�
::echo ������°����Ŀ¼
::rd /s /q E:\gitUpdate\test1

::echo �������Ŀ¼
::md E:\gitUpdate\test2


echo ����git��resourcesĿ¼
cd /d E:
CD E:\DataX\


set /p a=�����뿪ʼ�汾��a:
set /p b=����������汾��b:


echo ��ȡ���첢���
git diff %a% %b% --name-only | xargs zip DataUpdate.zip


rem echo git diff %a% %b% --name-only




::echo ��ѹ�����Ŀ¼
::tar -zxvf gengxinbao.tar.gz -C D:/update/test2/


::echo ɾ������ѹ����
::del gengxinbao.tar.gz


echo �㶨
echo ��������˳�
pause>nul
exit