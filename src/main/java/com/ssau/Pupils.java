package com.ssau;


import java.io.*;
import java.lang.reflect.Constructor;
import java.util.Scanner;


public class Pupils {

    private static PupilFactory _factory = new StudentFactory();

    public static void setPupilFactory(PupilFactory pupilFactory){
       _factory =  pupilFactory;
    }

    public static Pupil createInstance(String name, int size){
        return _factory.createInstance(name,size);
    }

    public static Pupil synchronizedPupil(Pupil p){
        SynchronizeStudent student = new SynchronizeStudent(p);
        return student;
    }

    public static boolean equals(Pupil a, Pupil b)
    {
        if (!(a.getName().equals(b.getName()))) return false;
        if (a.getLength()!=b.getLength()) return false;
        else
            for (int i=0;i<a.getLength();i++)
            {
                if (!(a.getSubject(i).equals(b.getSubject(i)))) return false;
                if (a.getMark(i)!=b.getMark(i)) return false;
            }
        return true;
    }

    public static void printSubjs(Pupil p)
    {
        int n = p.getLength();
        for (int i=0;i<n;i++)
        {
            System.out.println(p.getSubject(i));
        }
    }

    public static void printMarks(Pupil p)
    {
        int n = p.getLength();
        for (int i=0;i<n;i++)
        {
            System.out.println(p.getMark(i));
        }
    }

    public static double middle(Pupil...ps)
    {
        double q=0;
        int k = 0;
        for (Pupil p:ps)
        {
            for (int i=0;i<p.getLength();i++)
            {
                q+=p.getMark(i);
                k++;
            }
        }
        return q/k;
    }

    public static void outputPupil(Pupil v, OutputStream out)
    {
        DataOutputStream outs = new DataOutputStream(out);
        try
        {
            if (v instanceof Schoolboy) outs.writeBoolean(true);
            else outs.writeBoolean(false);
            int n = v.getName().getBytes().length;
            outs.writeInt(n);
            for (int i=0;i<n;i++)
            {
                outs.writeByte(v.getName().getBytes()[i]);
            }
            n = v.getLength();
            outs.writeInt(n);
            for (int i=0;i<n;i++)
            {
                int l = v.getSubject(i).getBytes().length;
                outs.writeInt(l);
                for (int j=0;j<l;j++)
                {
                    outs.writeByte(v.getSubject(i).getBytes()[j]);
                }
                outs.writeInt(v.getMark(i));
            }
        }
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public static Pupil inputPupil(InputStream in) throws IOException {
        Pupil v;
        DataInputStream ins = new DataInputStream(in);

            boolean b = ins.readBoolean();
            int n = ins.readInt();
            byte[] a = new byte[n];
            for (int i=0;i<n;i++)
            {
                a[i]=ins.readByte();
            }
            String s = new String(a);
            n = ins.readInt();
            if (b) v = new Schoolboy(s, n);
            else v = new Student(s, n);
            for (int i=0;i<n;i++)
            {
                int l;
                l = ins.readInt();
                a=new byte[l];
                for (int j=0;j<l;j++)
                {
                    a[j]=ins.readByte();
                }
                v.setSubject(i, new String(a));
                v.setMark(i, ins.readInt());
            }
            return v;
    }

    public static void writePupil(Pupil v, Writer out)
    {
        PrintWriter outp = new PrintWriter(out);
        if (v instanceof Schoolboy) outp.printf("%d%n",1);
        else outp.printf("%d%n",0);
        outp.printf(v.getName()+"%n");
        int n = v.getLength();
        outp.printf("%d%n",n);
        for (int i=0;i<n;i++)
        {
            outp.printf(v.getSubject(i)+"%n");
            outp.printf("%d%n",v.getMark(i));
        }
        outp.flush();
    }

    public static Pupil readPupil(Reader in)
    {
        Pupil p = null;
        Scanner s = new Scanner(in);
            if (s.nextInt()==0)
            {
                String st = s.next();
                int n = s.nextInt();
                p = new Student(st, n);
                for (int i=0;i<n;i++)
                {
                    p.setSubject(i, s.next());
                    p.setMark(i, s.nextInt());
                }
                return p;
            }
            else
            {
                String st = s.next();
                int n = s.nextInt();
                p = new Schoolboy(st, n);
                for (int i=0;i<n;i++)
                {
                    p.setSubject(i, s.next());
                    p.setMark(i, s.nextInt());
                }
                return p;
            }

    }

    public static Pupil createPupil(String f, int size, Pupil p)
    {
        try
        {
            Class c = p.getClass();
            Constructor cn = c.getConstructor(String.class, int.class);
            Object res = null;
            return (Pupil)cn.newInstance(f,size);
        }
        catch (Exception ex)
        {
            return null;
        }
    }
}
