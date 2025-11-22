import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { NewContactService } from '../services/new-contact.service';
import { Contact } from '../forms/contact.model';

@Component({
  selector: 'app-new-contact-component',
  standalone: false,
  templateUrl: './new-contact-component.html',
  styleUrl: './new-contact-component.css',
})
export class NewContactComponent {

    contacts: Contact [] = [];
    formGroupNewContactForm: FormGroup;

constructor(
  private formBuilder: FormBuilder,
  private service: NewContactService
) {
  this.formGroupNewContactForm = this.formBuilder.group({
    name: ['', [Validators.required, Validators.minLength(2)]],
    phone: ['', [Validators.required]],
    groupName: [''],
    email: ['', [Validators.email]],
    address: [''],
    notes: ['']
  });
}

  saveNewContact() {

    const contact: Contact = this.formGroupNewContactForm.value;

    this.service.create(contact).subscribe({
      next: saved => {
        alert("Contato salvo com sucesso!");

        this.contacts.push(saved);

        this.formGroupNewContactForm.reset();
      },
      error: err => {
        alert("Erro ao salvar contato.");
      }
    });
  }

  cancelNewContact() {
    this.formGroupNewContactForm.reset();
  }
}


