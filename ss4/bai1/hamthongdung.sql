use quanlysinhvien;
select subname,subid,max(credit) as MaxCredit from `subject`
group by subname,subid;
-- cau2 --
select S.subid,s.subname,max(mark)
from `subject` s join Mark m on s.subid = m.subid
group by S.subid,s.subname;
-- cau3 --
select s.studentid,s.studentname,avg(mark) from student s join mark m on s.studentid = m.studentid
group by s.studentid , s.studentname 
order by avg(mark) desc;