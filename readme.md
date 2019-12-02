# Spring boot ftp client

Spring boot project for using Apache Commons FTPClient through a simplified interface.

## Usage

Add the following dependency:

```
<dependency>
  <groupId>com.serikat.ftp</groupId>
  <artifactId>spring-boot-ftp-client</artifactId>
  <version>1</version>
</dependency>
```

Add the following to your application.yml:

```
ftp:
  username: username
  password: password
  server: server
```

Inject a FTPFileWriter like so:

```
@Inject
FTPFileWriter ftpFileWriter;
```

Connect and start using the FTPFileWriter

```
ftpFileWriter.open();
if(ftpFileWriter.isConnected()){
    ftpFileWriter.loadFile(path, outputstream);
    ftpFileWriter.saveFile(inputstream, remotepath, false);
    ftpFileWriter.saveFile(sourcepath, destpath, true);
}
ftpFileWriter.close();
```


## Configuration

By default port 21 is used and keepAliveTimeout is not set. You can change both these things by supplying these additional properties:

```
ftp:
  port: 21
  keepAliveTimout: 10
```

If you want the FTPFileWriter to connect as soon as it's injected, you can set this:

```
ftp:
  autoStart: true
```

If you want to access the FTPClient object you can extend FTPFileWriterImpl and make it the primary bean, like this:

```
@Primary
@Component
public class FTPFileWriterImplExt extends FTPFileWriterImpl {
    public void doSomething(){
        //this.ftpClient is accessible here.
    }
}
```

