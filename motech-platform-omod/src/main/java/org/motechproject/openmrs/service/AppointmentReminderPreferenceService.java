package org.motechproject.openmrs.service;


import org.motechproject.openmrs.dao.AppointmentReminderPreferenceDAO;
import org.motechproject.openmrs.model.AppointmentReminderPreferences;
import org.openmrs.Patient;
import org.openmrs.api.OpenmrsService;
import org.springframework.transaction.annotation.Transactional;

@Transactional()
public interface AppointmentReminderPreferenceService extends OpenmrsService {
	
    public void setAppointmentReminderPreferenceDAO(AppointmentReminderPreferenceDAO dao);

    /**
     * Get the appointment reminder preferences by the preference id
     * @param id Preference Id
     * @return Appointment reminder preferences associated with that id
     */
    public AppointmentReminderPreferences getAppointmentReminderPreferences(Integer id);
    
    /**
     * Save an appointment reminder preference
     * @param preferences Preference object to be saved
     * @return Stored preference object with id if not previously persisted
     */
    public AppointmentReminderPreferences saveAppointmentAppointmentReminderPreferences(AppointmentReminderPreferences preferences);

    /**
     * Retrieve the Appointment Reminder Preferences for a given user
     * @param patient user for whom the preferences are to be retrieved for
     * @return Appointment reminder object associated with the patient if any. null returned of not found.
     */
    public AppointmentReminderPreferences getAppointmentReminderPreferencesByPatient(Patient patient);

}
