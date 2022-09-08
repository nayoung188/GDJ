package service;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import domain.ContactDTO;
import repository.ContactDAO;

public class ContactServiceImpl implements ContactService {

	/***************** Field *****************/
	
	// DAO에 데이터를 전달하고, DAO로부터 결과를 반환 받기 위해서 DAO를 선언
	private ContactDAO dao = ContactDAO.getInstance();
	
	
	/***************** Method *****************/
	
	@Override
	public void addContact(ContactDTO contact) {
		int result = dao.insertContact(contact);
		if(result > 0) {
			System.out.println("연락처가 등록되었습니다.");
		} else {
			System.out.println("연락처 등록이 실패했습니다.");
		}
	}

	@Override
	public void modifyContact(ContactDTO contact) {
		int result = dao.updateContact(contact);
		if(result > 0) {
			System.out.println("연락처가 수정되었습니다.");
		} else {
			System.out.println("연락처 수정이 실패했습니다.");
		}
	}

	@Override
	public void deleteContact(int contact_no) {
		int result = dao.deleteContact(contact_no);
		if(result > 0) {
			System.out.println("연락처가 삭제되었습니다.");
		} else {
			System.out.println("연락처 삭제가 실패했습니다.");
		}
	}

	@Override
	public void findContactByNo(int contact_no) {
		ContactDTO contact = dao.selectContactByNo(contact_no);
		if(contact == null) {
			System.out.println("조회된 연락처가 없습니다.");
		} else {
			System.out.println(contact);
		}
	}

	@Override
	public void findAllContacts() {
		List<ContactDTO> contacts = dao.selectAllContacts();
		if(contacts.isEmpty()) {
			System.out.println("저장된 연락처가 없습니다.");
		} else {
			for(ContactDTO contact : contacts) {
				System.out.println(contact);
			}
		}
	}
	
	@Override
	public void createContactFile() {
		
		// 전체 연락처 목록을 가져온다.
		List<ContactDTO> contacts = dao.selectAllContacts();
		
		// File 객체를 만든다.
		// 경로를 작성하지 않으면 프로젝트 디렉터리에 파일이 생성된다.
		File file = new File("연락처.csv");
		
		// BufferedWriter 스트림을 만든다.
		// IOException 예외처리가 필요하다.
		// close가 필요 없는 try-catch-resources문을 이용한다.
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			
			// 제목을 작성하고 줄 바꿈 처리한다.
			bw.write("번호,이름,전화,이메일,등록일");
			bw.newLine();  // bw.write("\n")과 동일
			
			// 연락처 내용을 한 줄씩 작성한다.
			for(ContactDTO contact : contacts) {
				bw.write(contact.getContact_no() + ",");
				bw.write(contact.getName() + ",");
				bw.write(contact.getTel() + ",");
				bw.write(contact.getEmail() + ",");
				bw.write(new SimpleDateFormat("yy/MM/dd").format(contact.getReg_date()) + "\n");
			}
			
			System.out.println("연락처.csv 파일이 생성되었습니다.");
			
		} catch(IOException e) {
			System.out.println("연락처.csv 파일 생성이 실패했습니다.");
			e.printStackTrace();
		}
		
	}
	
}